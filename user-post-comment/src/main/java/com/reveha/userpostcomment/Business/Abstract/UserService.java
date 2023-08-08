package com.reveha.userpostcomment.Business.Abstract;

import com.reveha.userpostcomment.Business.Request.CreateNewUserRequest;
import com.reveha.userpostcomment.Business.Request.UpdateUserRequest;
import com.reveha.userpostcomment.Business.Response.GetAllUsers;
import com.reveha.userpostcomment.Business.Response.GetUserById;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public abstract class UserService {
    public abstract void  addUser(CreateNewUserRequest createNewUserRequest);
    public abstract void  deleteUser(Long id);
    public abstract void  updateUser(UpdateUserRequest updateUserRequest);
    public abstract List<GetAllUsers> getAllUsers();

    public abstract GetUserById getUserById(Long id);
}
