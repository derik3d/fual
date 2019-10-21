package com.app.fual.FualMain.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private List<UserDTO> participants;
    
	private List<CommentDTO> comments;

	
	

}
