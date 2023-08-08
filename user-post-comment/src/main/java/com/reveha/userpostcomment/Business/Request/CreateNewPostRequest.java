package com.reveha.userpostcomment.Business.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewPostRequest {
    private String title;
    private String content;
    private int likeNumber=0;
    private Long userID;
}
