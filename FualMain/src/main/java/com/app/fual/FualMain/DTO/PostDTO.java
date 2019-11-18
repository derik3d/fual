package com.app.fual.FualMain.DTO;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private UserDTO creator;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
    
    private String location;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)//a post must have a challenge
    private ChallengeDTO challenge;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> imageLink = new HashSet<>();
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="POST_USER_JTABLE")
    private Set<UserDTO> likedBy = new HashSet<>();
    
    private String description;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private PublicChatDTO chat;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> tags = new HashSet<>();

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

	public Set<String> getImageLink() {
		return imageLink;
	}

	public void setImageLink(Set<String> imageLink) {
		this.imageLink = imageLink;
	}

	public Set<UserDTO> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Set<UserDTO> likedBy) {
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

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((challenge == null) ? 0 : challenge.hashCode());
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageLink == null) ? 0 : imageLink.hashCode());
		result = prime * result + ((likedBy == null) ? 0 : likedBy.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		if (challenge == null) {
			if (other.challenge != null)
				return false;
		} else if (!challenge.equals(other.challenge))
			return false;
		if (chat == null) {
			if (other.chat != null)
				return false;
		} else if (!chat.equals(other.chat))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageLink == null) {
			if (other.imageLink != null)
				return false;
		} else if (!imageLink.equals(other.imageLink))
			return false;
		if (likedBy == null) {
			if (other.likedBy != null)
				return false;
		} else if (!likedBy.equals(other.likedBy))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", creator=" + creator + ", date=" + date + ", location=" + location
				+ ", challenge=" + challenge + ", imageLink=" + imageLink + ", likedBy=" + likedBy + ", description="
				+ description + ", chat=" + chat + ", tags=" + tags + "]";
	}
	
	////-------------------------------------------------------------
    
    
	
    
}
