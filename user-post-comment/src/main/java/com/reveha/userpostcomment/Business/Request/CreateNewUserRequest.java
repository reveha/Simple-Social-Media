package com.reveha.userpostcomment.Business.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewUserRequest {
    private String name;
    private String email;
    private String password;
}
