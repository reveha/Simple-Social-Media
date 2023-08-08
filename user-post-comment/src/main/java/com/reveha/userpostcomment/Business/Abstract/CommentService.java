package com.reveha.userpostcomment.Business.Abstract;

import com.reveha.userpostcomment.Business.Request.CreateNewCommentRequest;
import com.reveha.userpostcomment.Business.Request.UpdateCommentRequest;
import com.reveha.userpostcomment.Business.Response.GetAllComments;

import java.util.List;

public abstract class CommentService {

    public abstract void addComment(CreateNewCommentRequest createNewCommentRequest);

    public abstract void deleteComment(Long id);

    public abstract void updateComment(UpdateCommentRequest updateCommentRequest);

    public abstract List<GetAllComments> getAllCommentsByPostID(Long id);

    public abstract List<GetAllComments> getAllCommentsListByUserID(Long id);

    public abstract List<GetAllComments> getAllCommentsList();
}
