package com.example.demo.Comment;

import com.example.demo.Post.Post;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table//(name="COMMENTS")
public class Comment {
    @Id
    @GeneratedValue()
    private Long Id;
    private String message;
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post post;

    public Comment() {
    }

    public Comment(String message, Timestamp timestamp, Post p) {
        this.message = message;
        this.timestamp = timestamp;
        this.post = p;
    }

    public Comment(Long id, String message, Timestamp timestamp) {
        this.Id = id;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                //", PostId=" + post.getId() +
                '}';
    }
}
