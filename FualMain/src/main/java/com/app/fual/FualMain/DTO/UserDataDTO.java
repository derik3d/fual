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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public boolean isTrainer() {
		return isTrainer;
	}

	public void setTrainer(boolean isTrainer) {
		this.isTrainer = isTrainer;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getProfileImageLink() {
		return profileImageLink;
	}

	public void setProfileImageLink(String profileImageLink) {
		this.profileImageLink = profileImageLink;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<UserDTO> getFollows() {
		return follows;
	}

	public void setFollows(List<UserDTO> follows) {
		this.follows = follows;
	}

	public List<UserDTO> getFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(List<UserDTO> followedBy) {
		this.followedBy = followedBy;
	}

	public List<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}

	public List<PersonalChatDTO> getPersonalChats() {
		return personalChats;
	}

	public void setPersonalChats(List<PersonalChatDTO> personalChats) {
		this.personalChats = personalChats;
	}

	public List<UserDTO> getBlockedUsers() {
		return blockedUsers;
	}

	public void setBlockedUsers(List<UserDTO> blockedUsers) {
		this.blockedUsers = blockedUsers;
	}
	
	
	
}
