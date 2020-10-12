package com.cg.socialsite.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private Integer commentId;

private String commentBody;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="CommentedByUser")
private User commentBy;

@Temporal(value=TemporalType.TIMESTAMP)
private Date createdAt;

@Temporal(value=TemporalType.TIMESTAMP)
private Date updatedAt;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="commentedPostId")
private Post commentedPost;


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

public Post getCommentedPost() {
	return commentedPost;
}

public void setCommentedPost(Post commentedPost) {
	this.commentedPost = commentedPost;
}

public Comment(Integer commentId, String commentBody, User commentBy, Date createdAt, Date updatedAt,
		Post commentedPost) {
	super();
	this.commentId = commentId;
	this.commentBody = commentBody;
	this.commentBy = commentBy;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.commentedPost = commentedPost;
}

public Comment() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Comment [commentId=" + commentId + ", commentBody=" + commentBody + ", commentBy=" + commentBy
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", commentedPost=" + commentedPost + "]";
}

/*
 * @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL,fetch =
 * FetchType.EAGER) private List<Reply> replyOnComment;
 */




}
