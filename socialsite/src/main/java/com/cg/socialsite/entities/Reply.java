package com.cg.socialsite.entities;

//@Entity
public class Reply {
	
	//@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Integer replyId;
	
	//@ManyToOne
	//@JoinColumn(name="commentId")
	Comment comment;
	
	String replyBody;
	
	User repliedBy;
	

}
