package com.reveha.userpostcomment.Controller;


import com.reveha.userpostcomment.Business.Concretes.UserManager;
import com.reveha.userpostcomment.Business.Request.CreateNewUserRequest;
import com.reveha.userpostcomment.Business.Request.UpdateUserRequest;
import com.reveha.userpostcomment.Business.Response.GetAllUsers;
import com.reveha.userpostcomment.Business.Response.GetUserById;
import com.reveha.userpostcomment.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socialmedia/user")
public class UserController {
    private UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping("/addUser")
    public void addUser(CreateNewUserRequest createNewUserRequest){
        this.userManager.addUser(createNewUserRequest);
    }

    @PutMapping("/update")
    public void updateUser(UpdateUserRequest updateUserRequest){
        this.userManager.updateUser(updateUserRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userManager.deleteUser(id);
    }

    @GetMapping("/getAll")
    public List<GetAllUsers> getAllUsers(){
        return this.userManager.getAllUsers();
    }


    @GetMapping("/getById/{id}")
    public GetUserById getUserById(@PathVariable Long id){
        return this.userManager.getUserById(id);
    }

}
