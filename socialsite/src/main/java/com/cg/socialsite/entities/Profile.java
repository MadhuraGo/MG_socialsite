package com.cg.socialsite.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Profile {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Integer profileId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="profileOwnerId")
	User profileOwner;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(value=TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	String profileAbout;

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public User getProfileOwner() {
		return profileOwner;
	}

	public void setProfileOwner(User profileOwner) {
		this.profileOwner = profileOwner;
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

	public String getProfileAbout() {
		return profileAbout;
	}

	public void setProfileAbout(String profileAbout) {
		this.profileAbout = profileAbout;
	}

	public Profile(Integer profileId, User profileOwner, Date createdAt, Date updatedAt, String profileAbout) {
		super();
		this.profileId = profileId;
		this.profileOwner = profileOwner;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.profileAbout = profileAbout;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileOwner=" + profileOwner + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", profileAbout=" + profileAbout + "]";
	}
	
	
	
	
}
	
	
	
	
	


