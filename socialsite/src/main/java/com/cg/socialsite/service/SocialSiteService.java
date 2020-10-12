package com.cg.socialsite.service;

import java.util.List;

import com.cg.socialsite.dto.CommentDto;
import com.cg.socialsite.entities.Comment;
import com.cg.socialsite.entities.Post;
import com.cg.socialsite.entities.User;

public interface SocialSiteService {
	
	//CRUD for User
	
		public  User createUser(User user);
		//public Integer updateUser(User user);
		public Integer deleteUser(Integer userId);
		public User getUserbyId(Integer userId);
		public List<User> getAllUsers();
		
		
	//CRUD for Post
		
		public Post createPost(Post post);
		//public Integer updateUser(User user);
		public Integer deletePost(Integer postId);
		public Post getPostbyId(Integer postId);
		public List<Post> getAllPostsByUserId(Integer userId);
		public Post getPostByComment(Integer comment);
		
		public List<Post> getAllPostForAllUsers();
		
	//CRUD for Comment
		
		public Comment createComment(Comment comment);
		public Integer deleteComment(Integer commentId);
		public Comment getCommentById(Integer commentId);
		public List<CommentDto> getAllCommentsByPost(Post post);
		
		
	
		

}
