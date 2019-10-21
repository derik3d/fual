package com.app.fual.FualMain.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDataDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private UserDTO user;
    
	private boolean isTrainer;
    
	private String tag;
	
	private String profileImageLink;
	
	private String userInfo;
	
	private String city;
	
	private String country;
	
	private String gender;
	
	private int age;
	
	private int level;
    
	private List<UserDTO> follows;
	
	private List<UserDTO> followedBy;
	
	private List<PostDTO> posts;
    
	private List<PersonalChatDTO> personalChats;
    
	private List<UserDTO> blockedUsers;

	
	
	
}
