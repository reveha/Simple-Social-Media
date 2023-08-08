package com.reveha.userpostcomment.Business.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewCommentRequest {
    private String text;
    private Long postID;
    private Long userID;
}
