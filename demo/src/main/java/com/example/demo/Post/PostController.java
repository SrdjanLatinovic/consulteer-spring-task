package com.example.demo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/post")

public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }
    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long id){
        postService.deletePost(id);
    }
    @PutMapping(value = "/like") void addLike(@PathVariable("postId") Long id){
        postService.addLike(id);
    }
    @PutMapping(value = "/dislike") void addDisLike(@PathVariable("postId") Long id){
        postService.addDislike(id);
    }
}
