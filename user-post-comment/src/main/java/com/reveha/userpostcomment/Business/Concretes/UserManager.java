package com.reveha.userpostcomment.Business.Concretes;

import com.reveha.userpostcomment.Business.Abstract.UserService;
import com.reveha.userpostcomment.Business.Request.CreateNewUserRequest;
import com.reveha.userpostcomment.Business.Request.UpdateUserRequest;
import com.reveha.userpostcomment.Business.Response.GetAllUsers;
import com.reveha.userpostcomment.Business.Response.GetUserById;
import com.reveha.userpostcomment.Database.Abstract.UserRepository;
import com.reveha.userpostcomment.Database.Abstract.UserRepository;
import com.reveha.userpostcomment.Entities.Post;
import com.reveha.userpostcomment.Entities.User;
import com.reveha.userpostcomment.Mapper.ModelMapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserManager extends UserService {

    private final UserRepository userRepository;

    private final ModelMapperManager modelMapperService;

    @Autowired
    public UserManager(UserRepository userRepository, ModelMapperManager modelMapperManager) {
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperManager;
    }

    @Override
    public void addUser(CreateNewUserRequest createNewUserRequest) {
        User user=this.modelMapperService.forRequest().map(createNewUserRequest,User.class);
        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {
        User user=this.modelMapperService.forRequest().map(updateUserRequest,User.class);
        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUsers> getAllUsers() {
        List<User> userList=this.userRepository.findAll();

        System.out.println(userList.get(0).getPostList());

        List<GetAllUsers> getAllUsers=userList.stream()
                .map(users->this.modelMapperService.forResponse().map(users,GetAllUsers.class))
                .collect(Collectors.toList());

        return getAllUsers;
    }

    @Override
    public GetUserById getUserById(Long id) {
        User user=this.userRepository.getById(id);
        GetUserById getUserById=this.modelMapperService.forResponse().map(user,GetUserById.class);
        return getUserById;
    }


}
