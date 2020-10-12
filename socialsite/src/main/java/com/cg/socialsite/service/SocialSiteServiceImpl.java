package com.cg.socialsite.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.socialsite.dao.CommentDao;
import com.cg.socialsite.dao.PostDao;
import com.cg.socialsite.dao.ProfileDao;
import com.cg.socialsite.dao.UserDao;
import com.cg.socialsite.dto.CommentDto;
import com.cg.socialsite.entities.Comment;
import com.cg.socialsite.entities.Post;
import com.cg.socialsite.entities.Profile;
import com.cg.socialsite.entities.User;

@Service
public class SocialSiteServiceImpl implements SocialSiteService{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	ProfileDao profileDao;
	
	
	
	
	
	/************* User Operations *************/

	@Override
	public User createUser(User user) {
		//create user
		 profileDao.save(new Profile());
		return userDao.save(user);
	}

	@Override
	public Integer deleteUser(Integer userId) {
		 
		userDao.deleteById(userId);
		return userId;
	}

	@Override
	public User getUserbyId(Integer userId) {
		 
		return userDao.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		 
		return userDao.findAll();
	}
	
	
/************* Post Operations *************/
	
	@Override
	public Post createPost(Post post) {
		
		return postDao.save(post);
	}

	@Override
	public Integer deletePost(Integer postId) {
		 postDao.deleteById(postId);
		return postId;
	}

	@Override
	public Post getPostbyId(Integer postId) {
		 
		return postDao.findById(postId).get();
	}

	@Override
	public List<Post> getAllPostsByUserId(Integer userId) {
		 
		return postDao.findAll();
	}

	@Override
	public Post getPostByComment(Integer commentId) {
		
		Comment cmt=commentDao.findById(commentId).get();
		Post post=postDao.findById(cmt.getCommentedPost().getPostId()).get();
		 
		return post;
	}
	
	/************* Comment Operations *************/

	@Override
	public Comment createComment(Comment comment) {
		 
		return commentDao.save(comment);
	}

	@Override
	public Integer deleteComment(Integer commentId) {
		 
		commentDao.deleteById(commentId);
		return commentId;
	}

	@Override
	public Comment getCommentById(Integer commentId) {
		 
		return commentDao.findById(commentId).get();
	}

	@Override
	public List<CommentDto> getAllCommentsByPost(Post post) {
		
		List<CommentDto> comments=new ArrayList<CommentDto>();
		List<Comment> cmts=commentDao.findByCommentedPost(post);
		for (Comment comment : cmts) {
			comments.add(new CommentDto(comment.getCommentId(), 
							 comment.getCommentBody(), 
							 comment.getCommentBy(), 
							 comment.getCreatedAt(), 
							 comment.getUpdatedAt(), 
							 comment.getCommentedPost().getPostId())
					);
		}
		return comments;
		
		
	}

	@Override
	public List<Post> getAllPostForAllUsers() {
		//fetches all post for all users.
		return postDao.findAll();
	}

	
	
	
	
	

}
