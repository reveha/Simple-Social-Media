package com.reveha.userpostcomment.Business.Response;


import com.reveha.userpostcomment.Entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllComments {

    private String text;

    private Long postID;


}
