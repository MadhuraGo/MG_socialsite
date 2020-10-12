package com.cg.socialsite.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String userName;
	
	private String userPwd;
	
	@JsonIgnore
	@OneToMany(mappedBy = "postOwner",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commentBy",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Comment> commentOwner;
	

	private String userRole="enduser";
	
	@JsonIgnore
	@OneToOne(mappedBy = "profileOwner",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	Profile profile;

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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getCommentOwner() {
		return commentOwner;
	}

	public void setCommentOwner(List<Comment> commentOwner) {
		this.commentOwner = commentOwner;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public User(Integer userId, String userName, String userPwd, List<Post> posts, List<Comment> commentOwner,
			String userRole, Profile profile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.posts = posts;
		this.commentOwner = commentOwner;
		this.userRole = userRole;
		this.profile = profile;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", posts=" + posts
				+ ", commentOwner=" + commentOwner + ", userRole=" + userRole + ", profile=" + profile + "]";
	}
	
	
	

	
	
	
}
