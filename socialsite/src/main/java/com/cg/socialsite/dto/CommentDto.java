package com.cg.socialsite.dto;

import java.util.Date;

import com.cg.socialsite.entities.User;

public class CommentDto {
	
	private Integer commentId;

	private String commentBody;

	
	private User commentBy;

	
	private Date createdAt;

	
	private Date updatedAt;

	
	private Integer postId;


	public Integer getCommentId() {
		return commentId;
	}


	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}


	public String getCommentBody() {
		return commentBody;
	}


	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}


	public User getCommentBy() {
		return commentBy;
	}


	public void setCommentBy(User commentBy) {
		this.commentBy = commentBy;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", commentBody=" + commentBody + ", commentBy=" + commentBy
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", postId=" + postId + "]";
	}


	public CommentDto(Integer commentId, String commentBody, User commentBy, Date createdAt, Date updatedAt,
			Integer postId) {
		super();
		this.commentId = commentId;
		this.commentBody = commentBody;
		this.commentBy = commentBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.postId = postId;
	}


	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
