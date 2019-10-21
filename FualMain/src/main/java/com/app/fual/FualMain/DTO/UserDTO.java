package com.app.fual.FualMain.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="likes")
	private Set<CommentDTO> liked = new HashSet<>();
    
    @OneToMany()
    private Set<PostDTO> posts = new HashSet();

	
	
}
