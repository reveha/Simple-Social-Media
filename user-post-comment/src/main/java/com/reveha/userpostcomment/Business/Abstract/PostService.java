package com.reveha.userpostcomment.Business.Abstract;

import com.reveha.userpostcomment.Business.Request.CreateNewPostRequest;
import com.reveha.userpostcomment.Business.Request.UpdatePostRequest;
import com.reveha.userpostcomment.Business.Response.GetAllPosts;
import com.reveha.userpostcomment.Business.Response.GetPostById;

import java.util.List;

public abstract class PostService {



    public abstract void addPost(CreateNewPostRequest createNewPostRequest);
    public abstract void updatePost(UpdatePostRequest updatePostRequest);
    public abstract List<GetAllPosts> getAllPosts();
    public abstract GetPostById getPostById(Long id);

    public abstract void delete(Long id);
    public abstract List<GetAllPosts> getAllPostsByUserId(Long id);
}
