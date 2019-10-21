package com.app.fual.FualMain.DTO;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@ManyToOne
	private UserDTO creator;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private String location;
    
    @Column(nullable = false)
    private ChallengeDTO challenge;
    
    
    private List<String> imageLink;
    
    private List<UserDTO> likedBy;
    
    private String description;
    
    private PublicChatDTO chat;
    
    private List<String> tags;

	
    
}
