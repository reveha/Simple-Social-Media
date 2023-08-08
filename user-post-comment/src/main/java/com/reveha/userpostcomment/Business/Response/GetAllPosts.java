package com.reveha.userpostcomment.Business.Response;


import com.reveha.userpostcomment.Entities.Comment;
import com.reveha.userpostcomment.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPosts {
    private Long id;
    private String title;
    private String content;
    private int likeNumber;
    private Long userId;
    private String userName;
    List<GetAllComments> commentList;
}
