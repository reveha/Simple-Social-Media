package com.reveha.userpostcomment.Controller;

import com.reveha.userpostcomment.Business.Concretes.PostManager;
import com.reveha.userpostcomment.Business.Request.CreateNewPostRequest;
import com.reveha.userpostcomment.Business.Request.UpdatePostRequest;
import com.reveha.userpostcomment.Business.Response.GetAllPosts;
import com.reveha.userpostcomment.Business.Response.GetAllUsers;
import com.reveha.userpostcomment.Business.Response.GetPostById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socialmedia/posts")
public class PostController {

    private PostManager postManager;

    @Autowired
    public PostController(PostManager postManager) {
        this.postManager = postManager;
    }

    @PostMapping("/addPost")
    public void add(CreateNewPostRequest createNewPostRequest){
        this.postManager.addPost(createNewPostRequest);
    }

    @PutMapping("/updatePost")
    public void update(UpdatePostRequest updatePostRequest){
        this.postManager.updatePost(updatePostRequest);
    }

    @DeleteMapping("/deletePost/{id}")
    public void delete(@PathVariable Long id){
        this.postManager.delete(id);
    }

    @GetMapping("/gettAllPosts")
    public List<GetAllPosts> getAllPostsList(){
        return this.postManager.getAllPosts();
    }

    @GetMapping("/getPost/{id}")
    public GetPostById getPostById(@PathVariable Long id){
        return this.postManager.getPostById(id);
    }

    @GetMapping("/getPostsByUserId/{id}")
    public List<GetAllPosts> getAllPostsByUserId(@PathVariable Long id){
        return this.postManager.getAllPostsByUserId(id);
    }
}
