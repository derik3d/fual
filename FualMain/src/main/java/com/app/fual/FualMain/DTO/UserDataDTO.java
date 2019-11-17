package com.app.fual.FualMain.DTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserDataDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(nullable=false)
	@OneToOne(fetch = FetchType.EAGER)
	private UserDTO user;
    
	@Column(nullable = false)
	private boolean isTrainer = false;
    
	private String tag;
	
	private String profileImageLink;
	
	private String userInfo;
	
	private String city;
	
	private String country;
	
	private String gender;
	
	private Integer age;
	
	private Integer level;
	
	private Integer expLevel;
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="FOLLOWS_USERDATA_JTABLE")
	private Set<UserDTO> follows = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="FOLLOWED_USERDATA_JTABLE")
	private Set<UserDTO> followedBy = new HashSet<>();
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "creator")
	private Set<PostDTO> postsCreated = new HashSet<>();
    
	@OneToMany(fetch = FetchType.EAGER)
	private Set<PrivateChatDTO> privateChats = new HashSet<>();
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="BLOCKEDUSERS_USERDATA_JTABLE")
	private Set<UserDTO> blockedUsers = new HashSet<>();

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getExpLevel() {
		return expLevel;
	}

	public void setExpLevel(Integer expLevel) {
		this.expLevel = expLevel;
	}

	public Set<UserDTO> getFollows() {
		return follows;
	}

	public void setFollows(Set<UserDTO> follows) {
		this.follows = follows;
	}

	public Set<UserDTO> getFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(Set<UserDTO> followedBy) {
		this.followedBy = followedBy;
	}

	public Set<PostDTO> getPostsCreated() {
		return postsCreated;
	}

	public void setPostsCreated(Set<PostDTO> postsCreated) {
		this.postsCreated = postsCreated;
	}

	public Set<PrivateChatDTO> getPrivateChats() {
		return privateChats;
	}

	public void setPrivateChats(Set<PrivateChatDTO> privateChats) {
		this.privateChats = privateChats;
	}

	public Set<UserDTO> getBlockedUsers() {
		return blockedUsers;
	}

	public void setBlockedUsers(Set<UserDTO> blockedUsers) {
		this.blockedUsers = blockedUsers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((blockedUsers == null) ? 0 : blockedUsers.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((expLevel == null) ? 0 : expLevel.hashCode());
		result = prime * result + ((followedBy == null) ? 0 : followedBy.hashCode());
		result = prime * result + ((follows == null) ? 0 : follows.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isTrainer ? 1231 : 1237);
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((postsCreated == null) ? 0 : postsCreated.hashCode());
		result = prime * result + ((privateChats == null) ? 0 : privateChats.hashCode());
		result = prime * result + ((profileImageLink == null) ? 0 : profileImageLink.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userInfo == null) ? 0 : userInfo.hashCode());
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
		UserDataDTO other = (UserDataDTO) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (blockedUsers == null) {
			if (other.blockedUsers != null)
				return false;
		} else if (!blockedUsers.equals(other.blockedUsers))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (expLevel == null) {
			if (other.expLevel != null)
				return false;
		} else if (!expLevel.equals(other.expLevel))
			return false;
		if (followedBy == null) {
			if (other.followedBy != null)
				return false;
		} else if (!followedBy.equals(other.followedBy))
			return false;
		if (follows == null) {
			if (other.follows != null)
				return false;
		} else if (!follows.equals(other.follows))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isTrainer != other.isTrainer)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (postsCreated == null) {
			if (other.postsCreated != null)
				return false;
		} else if (!postsCreated.equals(other.postsCreated))
			return false;
		if (privateChats == null) {
			if (other.privateChats != null)
				return false;
		} else if (!privateChats.equals(other.privateChats))
			return false;
		if (profileImageLink == null) {
			if (other.profileImageLink != null)
				return false;
		} else if (!profileImageLink.equals(other.profileImageLink))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDataDTO [id=" + id + ", user=" + user + ", isTrainer=" + isTrainer + ", tag=" + tag
				+ ", profileImageLink=" + profileImageLink + ", userInfo=" + userInfo + ", city=" + city + ", country="
				+ country + ", gender=" + gender + ", age=" + age + ", level=" + level + ", expLevel=" + expLevel
				+ ", follows=" + follows + ", followedBy=" + followedBy + ", postsCreated=" + postsCreated
				+ ", privateChats=" + privateChats + ", blockedUsers=" + blockedUsers + "]";
	}

	
	
}
