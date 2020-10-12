package com.cg.socialsite.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.socialsite.dto.CommentDto;
import com.cg.socialsite.dto.PostWithComment;
import com.cg.socialsite.entities.Comment;
import com.cg.socialsite.entities.Post;
import com.cg.socialsite.entities.User;
import com.cg.socialsite.service.SocialSiteService;

@RestController
@RequestMapping("/socialsite")
public class SocialSiteController {
	
	@Autowired
	SocialSiteService siteService;
	
	//createpost
	@PostMapping("/createpost")
	public Post createPost(@RequestBody PostWithComment postdto) {
		
		Post post =new Post();
		post.setPostId(postdto.getPostId());
		post.setDescription(postdto.getPostBody());
		post.setPostOwner(siteService.getUserbyId(postdto.getUserId()));
		post.setCreatedAt(new Date());
		post.setUpdatedAt(new Date());
		
		return siteService.createPost(post);
	}
	
	//make new comment on existing post
	@PostMapping("/createcomment")
	public Comment createComment(@RequestBody CommentDto commentdto) {
		
		Comment comment=new Comment( commentdto.getCommentId(), 
								commentdto.getCommentBody(), 
								siteService.getUserbyId(commentdto.getCommentBy().getUserId()), 
								commentdto.getCreatedAt(), 
								commentdto.getUpdatedAt(), 
								siteService.getPostbyId(commentdto.getPostId()));
		
		return  siteService.createComment(comment);
	}
	
	//delete post
	@DeleteMapping("/deletepost/{postId}")
	public Integer deletePost(@PathVariable("postId") Integer postId) {
		return siteService.deletePost(postId);
	}
	
	//delete comment
	@DeleteMapping("/deletecomment/{cmtId}")
	public Integer deleteComment(@PathVariable("cmtId") Integer cmtId) {
		return siteService.deleteComment(cmtId);
	}
	
	//get all post for user
	@GetMapping("/getallpostforuser/{userId}")
	public List<PostWithComment> getAllPostByUser(@PathVariable("userId") Integer userId){
		
		List<Post> posts=siteService.getAllPostsByUserId(userId);
		List<PostWithComment> postdtos=new ArrayList<PostWithComment>();
		
		posts.forEach((post) -> {postdtos.add(this.getallcmtforPost(post.getPostId()));});
		return postdtos;
		
	}
	
	
	

	//create user
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return siteService.createUser(user);
	}
	
	
	//get all comments for post
	
	
	@GetMapping("/getpostwithallcomments/{postId}")
	public PostWithComment getallcmtforPost(@PathVariable("postId") Integer postId){
		
		 Post post=siteService.getPostbyId(postId);
		
		 PostWithComment postdto=new PostWithComment(postId,
				 									post.getPostOwner().getUserId(), 
				 									post.getPostOwner().getUserName(), 
				 									post.getDescription(), 
				 									siteService.getAllCommentsByPost(post)
				 									) ;

		 return postdto;
		 
				 
	}
	
	//getAllPostForAllUsers
	@GetMapping("/publicposts")
	public List<PostWithComment> getAllPostFOrALlUsers(){
		
		List<Post> allPosts=siteService.getAllPostForAllUsers();
		List<PostWithComment> publicposts=new ArrayList<PostWithComment>();
		allPosts.forEach((post) -> {
		    Integer  id=post.getPostId();
		    publicposts.add(this.getallcmtforPost(id));
		      
		    });
		
		return publicposts;
	}
	
	
	
	
	

	
	

}
