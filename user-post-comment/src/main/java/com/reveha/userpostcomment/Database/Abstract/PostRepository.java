package com.reveha.userpostcomment.Database.Abstract;

import com.reveha.userpostcomment.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
