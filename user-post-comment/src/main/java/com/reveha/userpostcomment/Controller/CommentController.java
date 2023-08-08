package com.reveha.userpostcomment.Controller;

import com.reveha.userpostcomment.Business.Concretes.CommentManager;
import com.reveha.userpostcomment.Business.Request.CreateNewCommentRequest;
import com.reveha.userpostcomment.Business.Request.UpdateCommentRequest;
import com.reveha.userpostcomment.Business.Response.GetAllComments;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socialmedia/comments")
@AllArgsConstructor
public class CommentController {

    private final CommentManager commentManager;

    @PostMapping("/addComment")
    public void addComment(CreateNewCommentRequest createNewCommentRequest){
        this.commentManager.addComment(createNewCommentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable Long id){
        this.commentManager.deleteComment(id);
    }

    @PutMapping("/updateComment")
    public void updateComment(UpdateCommentRequest updateCommentRequest){
        this.commentManager.updateComment(updateCommentRequest);
    }

    @GetMapping("/getByUserID/{id}")
    public List<GetAllComments> getAllCommentsListByUserID(@PathVariable Long id){
        return this.commentManager.getAllCommentsListByUserID(id);
    }


    @GetMapping("/getByPostID/{id}")
    public List<GetAllComments> getAllCommentsListByPostID(@PathVariable Long id){
        return this.commentManager.getAllCommentsByPostID(id);
    }


    @GetMapping("/gettAlComments")
    public List<GetAllComments> getAllComments(){
        return this.commentManager.getAllCommentsList();
    }
}
