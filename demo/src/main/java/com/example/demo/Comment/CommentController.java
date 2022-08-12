package com.example.demo.Comment;

import com.example.demo.Post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComment(){
        return commentService.getComments();
    }

    @PostMapping
    public void addNewComment(Comment comment, Long postId){
        commentService.addNewComment(comment,postId);
    }
}
