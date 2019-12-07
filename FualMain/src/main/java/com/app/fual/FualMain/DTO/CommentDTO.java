package com.app.fual.FualMain.DTO;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommentDTO implements Comparable<CommentDTO>{
	
	@Override
	public int compareTo(CommentDTO other){
		return this.date.compareTo(other.date);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private boolean status = false;
    
	@ManyToOne
	@JoinColumn(nullable = false)
	private UserDTO sender;
	
	@Column(nullable = false)
	private String message;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="COMMENT_USER_JTABLE")
    private Set<UserDTO> likedBy = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserDTO getSender() {
		return sender;
	}

	public void setSender(UserDTO sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<UserDTO> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Set<UserDTO> likedBy) {
		this.likedBy = likedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((likedBy == null) ? 0 : likedBy.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		CommentDTO other = (CommentDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (likedBy == null) {
			if (other.likedBy != null)
				return false;
		} else if (!likedBy.equals(other.likedBy))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", status=" + status + ", sender=" + sender + ", message=" + message + ", date="
				+ date + ", likedBy=" + likedBy + "]";
	}
	
	
	
	////-------------------------------------------------------------

	

}
