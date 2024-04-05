package com.dogac.questionapp.service;

import com.dogac.questionapp.entities.Likes;
import com.dogac.questionapp.repo.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }
    public List<Likes> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent() ){
            return likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }
        else if(userId.isPresent()){
            return likeRepository.findByUserId(userId);
        }
        else if (postId.isPresent()){
            return likeRepository.findByPostId(postId);
        }else
            return null;
    }
    public Likes getOneLikeById(Long likeId) {
    return likeRepository.findById(likeId).orElse(null);
    }

    public Likes createOneLike(Likes like) {
        return likeRepository.save(like);
    }

    public void deleteLikeById(Long likeId) {
    likeRepository.deleteById(likeId);
    }
}

