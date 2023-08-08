package com.reveha.userpostcomment.Business.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserById {
    private String name;
    private String email;

}