package com.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Comment;


public interface CommentRepo extends JpaRepository<Comment, Integer>{

}