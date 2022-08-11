package com.example.demo.Post;

import com.example.demo.Comment.Comment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table//(name="POST")
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private Timestamp timestamp;

    private Integer likes  = 0;

    private Integer dislikes = 0;

    @OneToMany(mappedBy="post")
    private List<Comment> commentList;


    public Post() {
    }

    public Post(Long id, String text, Timestamp timestamp) {
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Post(String text, Timestamp timestamp) {
        this.text = text;
        this.timestamp = timestamp;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
