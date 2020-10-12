package com.cg.socialsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.socialsite.entities.Comment;
import com.cg.socialsite.entities.Post;

public interface CommentDao extends JpaRepository<Comment, Integer> {
	
	
public List<Comment> findByCommentedPost(Post commentedPost);


}
