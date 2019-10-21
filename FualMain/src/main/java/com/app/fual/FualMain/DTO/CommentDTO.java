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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommentDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private boolean status = false;
    
	@Column(nullable = false)
	private UserDTO sender;
	
	@Column(nullable = false)
	private String message;
    
	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="COMMENT_USER")
    private Set<UserDTO> likes = new HashSet<>();

	

}
