package com.cg.socialsite.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="postOwnerId")
	private User  postOwner;
	
	private String description;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commentedPost",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public User getPostOwner() {
		return postOwner;
	}

	public void setPostOwner(User postOwner) {
		this.postOwner = postOwner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Post(Integer postId, User postOwner, String description, Date createdAt, Date updatedAt,
			List<Comment> comments) {
		super();
		this.postId = postId;
		this.postOwner = postOwner;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.comments = comments;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postOwner=" + postOwner + ", description=" + description + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", comments=" + comments + "]";
	}
	
	
	
	
	
	
	
	

}
