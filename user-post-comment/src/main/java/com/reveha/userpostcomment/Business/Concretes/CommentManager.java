package com.reveha.userpostcomment.Business.Concretes;

import com.reveha.userpostcomment.Business.Abstract.CommentService;
import com.reveha.userpostcomment.Business.Request.CreateNewCommentRequest;
import com.reveha.userpostcomment.Business.Request.UpdateCommentRequest;
import com.reveha.userpostcomment.Business.Response.GetAllComments;
import com.reveha.userpostcomment.Database.Abstract.CommentRepository;
import com.reveha.userpostcomment.Database.Abstract.PostRepository;
import com.reveha.userpostcomment.Entities.Comment;
import com.reveha.userpostcomment.Entities.Post;
import com.reveha.userpostcomment.Mapper.ModelMapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentManager extends CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final ModelMapperManager modelMapperManager;

    @Autowired
    public CommentManager(CommentRepository commentRepository, ModelMapperManager modelMapperManager, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.modelMapperManager=modelMapperManager;
        this.postRepository=postRepository;
    }

    @Override
    public void addComment(CreateNewCommentRequest createNewCommentRequest) {

        Comment comment=this.modelMapperManager.forRequest().map(createNewCommentRequest,Comment.class);



        this.commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        this.commentRepository.deleteById(id);
    }

    @Override
    public void updateComment(UpdateCommentRequest updateCommentRequest) {
        Comment comment=this.modelMapperManager.forRequest().map(updateCommentRequest,Comment.class);
        this.commentRepository.save(comment);
    }

    @Override
    public List<GetAllComments> getAllCommentsByPostID(Long id) {
        List<Comment> commentList=this.commentRepository.findAll();
        List<GetAllComments> getAllComments=new ArrayList<>();

        for(Comment comment:commentList){
            if(comment.getPost().getID()==id){
                getAllComments.add(this.modelMapperManager.forResponse().map(comment,GetAllComments.class));
            }
        }
        return getAllComments;
    }

    @Override
    public List<GetAllComments> getAllCommentsListByUserID(Long id) {
        List<Comment> commentList=this.commentRepository.findAll();
        List<GetAllComments> getAllComments=new ArrayList<>();

        for(Comment comment:commentList){
            if(comment.getPost().getUser().getID()==id){
                getAllComments.add(this.modelMapperManager.forResponse().map(comment,GetAllComments.class));
            }
        }
        return getAllComments;
    }

    @Override
    public List<GetAllComments> getAllCommentsList(){
        List<Comment> commentList=this.commentRepository.findAll();
        List<GetAllComments> getAllComments=commentList.stream()
                .map(comment -> this.modelMapperManager.forResponse()
                .map(comment,GetAllComments.class)).collect(Collectors.toList());

        return getAllComments;
    }
}
