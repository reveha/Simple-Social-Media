package com.reveha.userpostcomment.Business.Response;


import com.reveha.userpostcomment.Entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsers {
    private Long id;
    private String name;
    private String email;
    private List<GetAllPosts> postList;

}
