package com.cg.socialsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.socialsite.entities.Post;

public interface PostDao extends JpaRepository<Post, Integer> {
	 

}
