package com.example.demo.Post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    //@Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        Optional<Post> postById = postRepository.findPostById(post.getId());
        if(postById.isPresent())
            throw new IllegalStateException("id taken");
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
       boolean exists = postRepository.existsById(id);
       if(!exists){
           throw new IllegalStateException("doesnt exist");
       }
       postRepository.deleteById(id);
    }

    public void addLike(Long id) {
        boolean exists = postRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("doesnt exist");
        }
        Post p =postRepository.findPostById(id).get();
        p.addLike();
        postRepository.save(p);
    }

    public void addDislike(Long id) {
        boolean exists = postRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("doesnt exist");
        }
        Post p =postRepository.findPostById(id).get();
        p.addDislike();
        postRepository.save(p);
    }
}
//new Post(
//        1L,
//        "test",
//        Timestamp.from(Instant.now())
//        )