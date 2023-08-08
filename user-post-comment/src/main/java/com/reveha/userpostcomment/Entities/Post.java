package com.reveha.userpostcomment.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {


    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="likeNumber")
    private int likeNumber=0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likeNumber=" + likeNumber +
                ", commentList=" + commentList +
                '}';
    }
}
