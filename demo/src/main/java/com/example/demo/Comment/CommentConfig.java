package com.example.demo.Comment;

import com.example.demo.Post.Post;
import com.example.demo.Post.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Configuration
public class CommentConfig {
    @Bean
    CommandLineRunner commandLineRunner(CommentRepository repository, PostRepository postRepository){
        return args -> {
//            Optional<Post> p = postRepository.findPostById(3l);
//
//            Comment comment1 = new Comment(
//                    "test",
//                    Timestamp.from(Instant.now()),
//                    p.get()
//            );
//            Comment comment2 = new Comment(
//                    "test2",
//                    Timestamp.from(Instant.now()),
//                    p.get()
//            );
//            repository.saveAll(
//                    List.of(comment2,comment1)
//            );
        };
    }
}
