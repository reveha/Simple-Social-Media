package com.reveha.userpostcomment.Database.Abstract;

import com.reveha.userpostcomment.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
