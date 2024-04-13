package com.dogac.questionapp.service;

import com.dogac.questionapp.entities.Post;
import com.dogac.questionapp.entities.User;
import com.dogac.questionapp.repo.PostRepository;
import com.dogac.questionapp.requests.PostCreateRequest;
import com.dogac.questionapp.requests.PostResponse;
import com.dogac.questionapp.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository,UserService userService){
        this.postRepository= postRepository;
        this.userService = userService;
    }

    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List <Post>  list;

        if(userId.isPresent()){
        list = postRepository.findByUserId(userId.get());
    }
       list = postRepository.findAll();
       return list.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());
    }
    public Post createOnePost(PostCreateRequest newPostCreateRequest) {
    User user = userService.getOneUserById(newPostCreateRequest.getUserId());
    if(user == null)
        return null;
    Post toSave = new Post();
    toSave.setId(newPostCreateRequest.getId());
    toSave.setText(newPostCreateRequest.getText());
    toSave.setTitle(newPostCreateRequest.getTitle());
    toSave.setUser(user);
     return postRepository.save(toSave);
    }
    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
    Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
    public void deletePostById(Long postId) {
         postRepository.deleteById(postId);
    }
}
