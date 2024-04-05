package com.dogac.questionapp.controller;

import com.dogac.questionapp.entities.Comment;
import com.dogac.questionapp.requests.CommentCreateRequest;
import com.dogac.questionapp.requests.CommentUpdateRequest;
import com.dogac.questionapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class    CommentController {
    private  CommentService commentService ;

    public CommentController (CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComment (@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getAllCommentWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneCommentById(@PathVariable Long commentId){
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping()
    public Comment createOneComment(@RequestBody CommentCreateRequest request){
            return commentService.createOneComment(request);
    }
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateOneCommentById(commentId,request);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
         commentService.deleteOneComment(commentId);
    }
}
