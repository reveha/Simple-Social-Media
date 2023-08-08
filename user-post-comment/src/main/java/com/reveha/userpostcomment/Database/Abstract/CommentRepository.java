package com.reveha.userpostcomment.Database.Abstract;

import com.reveha.userpostcomment.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
