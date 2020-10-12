package com.cg.socialsite.dto;

import java.io.Serializable;
import java.util.List;

public class PostWithComment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9168808773936802407L;
	Integer postId;
	Integer userId;
	String userName;
	String postBody;
	List<CommentDto> comments;
	
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	public List<CommentDto> getComments() {
		return comments;
	}
	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PostWithComment(Integer postId, Integer userId, String userName, String postBody,
			List<CommentDto> comments) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.userName = userName;
		this.postBody = postBody;
		this.comments = comments;
	}
	public PostWithComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PostWithComment [postId=" + postId + ", userId=" + userId + ", userName=" + userName + ", postBody="
				+ postBody + ", comments=" + comments + "]";
	}
	
	
	
	
	
		
	
	
}
