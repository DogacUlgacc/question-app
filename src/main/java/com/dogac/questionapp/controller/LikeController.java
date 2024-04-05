package com.dogac.questionapp.controller;

import com.dogac.questionapp.entities.Comment;
import com.dogac.questionapp.entities.Likes;
import com.dogac.questionapp.requests.CommentCreateRequest;
import com.dogac.questionapp.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }
    @GetMapping
    public List<Likes> getAllLike(@RequestParam Optional<Long> userId, @RequestParam Optional <Long> postId){
        return likeService.getAllLikes(userId,postId);
    }

    @GetMapping("/{likeId}")
    public Likes getOneLikeById(@RequestParam Long likeId){
        return likeService.getOneLikeById(likeId);
    }
    @PostMapping()
    public Likes createOneLike(@RequestBody Likes like){
        return likeService.createOneLike(like);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        likeService.deleteLikeById(likeId);
    }
}

