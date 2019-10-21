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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((blockedUsers == null) ? 0 : blockedUsers.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((followedBy == null) ? 0 : followedBy.hashCode());
		result = prime * result + ((follows == null) ? 0 : follows.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isTrainer ? 1231 : 1237);
		result = prime * result + level;
		result = prime * result + ((personalChats == null) ? 0 : personalChats.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
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
		if (age != other.age)
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
		if (level != other.level)
			return false;
		if (personalChats == null) {
			if (other.personalChats != null)
				return false;
		} else if (!personalChats.equals(other.personalChats))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
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
				+ country + ", gender=" + gender + ", age=" + age + ", level=" + level + ", follows=" + follows
				+ ", followedBy=" + followedBy + ", posts=" + posts + ", personalChats=" + personalChats
				+ ", blockedUsers=" + blockedUsers + "]";
	}
	
	
	
}
