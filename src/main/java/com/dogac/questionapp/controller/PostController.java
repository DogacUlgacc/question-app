package com.dogac.questionapp.controller;

import com.dogac.questionapp.entities.Post;
import com.dogac.questionapp.requests.PostCreateRequest;
import com.dogac.questionapp.requests.PostResponse;
import com.dogac.questionapp.requests.PostUpdateRequest;
import com.dogac.questionapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("posts")
public class PostController {

    private PostService postService;


    public PostController (PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts (@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost (@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createOnePost(postCreateRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePostById(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePostById(postId,postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
         postService.deletePostById(postId);
    }


}
