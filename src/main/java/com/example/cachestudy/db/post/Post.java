package com.example.cachestudy.db.post;

import com.example.cachestudy.db.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;


    public static Post create(String content) {
        var post = new Post();
        post.content = content;
        return post;
    }


}
