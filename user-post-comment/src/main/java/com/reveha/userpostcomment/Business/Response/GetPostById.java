package com.reveha.userpostcomment.Business.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostById {

    private String title;

    private String content;

}
