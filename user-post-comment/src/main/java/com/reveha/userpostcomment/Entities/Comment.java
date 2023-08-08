package com.reveha.userpostcomment.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity{

    @Column(name="text")
    private String text;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posts_id")
    private Post post;


    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                '}';
    }
}
