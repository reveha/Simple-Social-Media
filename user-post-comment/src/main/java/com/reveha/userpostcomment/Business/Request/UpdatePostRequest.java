package com.reveha.userpostcomment.Business.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {
    private Long id;
    private String title;
    private String content;
}
