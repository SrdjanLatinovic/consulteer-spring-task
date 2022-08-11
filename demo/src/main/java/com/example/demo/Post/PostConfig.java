package com.example.demo.Post;

import com.example.demo.Comment.Comment;
import com.example.demo.Comment.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Configuration
public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner2(PostRepository postRepository, CommentRepository repository){
        return args -> {
            Post post1 = new Post(
                    1L,
                    "test",
                    Timestamp.from(Instant.now())
            );

            Post post2 = new Post(
                    2L,
                    "test2",
                    Timestamp.from(Instant.now())
            );

            Comment comment1 = new Comment(
                    "test",
                    Timestamp.from(Instant.now()),
                    post1
            );

            Comment comment2 = new Comment(
                    "test2",
                    Timestamp.from(Instant.now()),
                    post2
            );

            postRepository.saveAll(
                    List.of(post1, post2)
            );

            repository.saveAll(
                    List.of(comment2, comment1)
            );
        };
    }
}
