package com.reveha.userpostcomment.Business.Concretes;

import com.reveha.userpostcomment.Business.Abstract.PostService;
import com.reveha.userpostcomment.Business.Request.CreateNewPostRequest;
import com.reveha.userpostcomment.Business.Request.UpdatePostRequest;
import com.reveha.userpostcomment.Business.Response.GetAllPosts;
import com.reveha.userpostcomment.Business.Response.GetPostById;
import com.reveha.userpostcomment.Database.Abstract.PostRepository;
import com.reveha.userpostcomment.Database.Abstract.UserRepository;
import com.reveha.userpostcomment.Entities.Post;
import com.reveha.userpostcomment.Entities.User;
import com.reveha.userpostcomment.Mapper.ModelMapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostManager extends PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapperManager modelMapperManager;

    @Autowired
    public PostManager(PostRepository postRepository , UserRepository userRepository, ModelMapperManager modelMapperManager) {
        this.postRepository = postRepository;
        this.modelMapperManager = modelMapperManager;
        this.userRepository=userRepository;
    }

    @Override
    public void addPost(CreateNewPostRequest createNewPostRequest){


        Post post=this.modelMapperManager.forRequest().map(createNewPostRequest,Post.class);

        List<User> userList=this.userRepository.findAll();

        for(User user:userList){
            if(user.getID()==createNewPostRequest.getUserID()){
                user.getPostList().add(post);
                this.userRepository.save(user);
                break;
            }
        }

        this.postRepository.save(post);
    }

    @Override
    public void updatePost(UpdatePostRequest updatePostRequest){
        Post post=this.modelMapperManager.forRequest().map(updatePostRequest,Post.class);
        this.postRepository.save(post);
    }

    @Override
    public List<GetAllPosts> getAllPosts(){
        List<Post> postList=this.postRepository.findAll();

        List<GetAllPosts> getAllPosts=postList.stream()
                .map(posts->this.modelMapperManager.forResponse().map(posts,GetAllPosts.class))
                .collect(Collectors.toList());

        return getAllPosts;
    }

    @Override
    public GetPostById getPostById(Long id){
        Post post=this.postRepository.getById(id);
        GetPostById getpostById=this.modelMapperManager.forResponse().map(post,GetPostById.class);
        return getpostById;
    }

    @Override
    public void delete(Long id){
        this.postRepository.deleteById(id);
    }

    @Override
    public List<GetAllPosts> getAllPostsByUserId(Long id){
        List<Post> postList=this.postRepository.findAll();
        List<GetAllPosts> getAllPosts=new ArrayList<>();
        for(Post post:postList){
            if(post.getUser().getID()!=null){
                if(post.getUser().getID()==id){
                    getAllPosts.add(this.modelMapperManager.forResponse().map(post,GetAllPosts.class));
                }
            }
        }

        return getAllPosts;
    }

}
