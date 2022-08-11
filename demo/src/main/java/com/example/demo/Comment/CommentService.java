package com.example.demo.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }
}
//List.of(
//        new Comment(
//        11L,
//        "test",
//        Timestamp.from(Instant.now()),
//        1L
//        )
//        );