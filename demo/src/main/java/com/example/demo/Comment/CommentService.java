package com.example.demo.Comment;

import com.example.demo.Post.Post;
import com.example.demo.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }


    public void addNewComment(@RequestBody Comment comment, Long postId) {
        Post p = postRepository.findPostById(postId).get();
        if(p != null){
            commentRepository.save(comment);
        }
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