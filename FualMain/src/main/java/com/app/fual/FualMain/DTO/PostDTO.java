package com.app.fual.FualMain.DTO;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private UserDTO creator;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private String location;
    
    private ChallengeDTO challenge;
    
    private List<String> imageLink;
    
    private List<UserDTO> likedBy;
    
    private String description;
    
    private PublicChatDTO chat;
    
    private List<String> tags;

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

	public UserDTO getCreator() {
		return creator;
	}

	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ChallengeDTO getChallenge() {
		return challenge;
	}

	public void setChallenge(ChallengeDTO challenge) {
		this.challenge = challenge;
	}

	public List<String> getImageLink() {
		return imageLink;
	}

	public void setImageLink(List<String> imageLink) {
		this.imageLink = imageLink;
	}

	public List<UserDTO> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(List<UserDTO> likedBy) {
		this.likedBy = likedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PublicChatDTO getChat() {
		return chat;
	}

	public void setChat(PublicChatDTO chat) {
		this.chat = chat;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
    
    
    
}
