package com.app.fual.FualMain.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChallengeDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String level;
    
	private String description;
    
	private String duration;
	
	private String movement;
	
	private String workout;
	
	private String sets;

	private String rest;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	public String getWorkout() {
		return workout;
	}

	public void setWorkout(String workout) {
		this.workout = workout;
	}

	public String getSets() {
		return sets;
	}

	public void setSets(String sets) {
		this.sets = sets;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((movement == null) ? 0 : movement.hashCode());
		result = prime * result + ((rest == null) ? 0 : rest.hashCode());
		result = prime * result + ((sets == null) ? 0 : sets.hashCode());
		result = prime * result + ((workout == null) ? 0 : workout.hashCode());
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
		ChallengeDTO other = (ChallengeDTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (movement == null) {
			if (other.movement != null)
				return false;
		} else if (!movement.equals(other.movement))
			return false;
		if (rest == null) {
			if (other.rest != null)
				return false;
		} else if (!rest.equals(other.rest))
			return false;
		if (sets == null) {
			if (other.sets != null)
				return false;
		} else if (!sets.equals(other.sets))
			return false;
		if (workout == null) {
			if (other.workout != null)
				return false;
		} else if (!workout.equals(other.workout))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChallengeDTO [id=" + id + ", level=" + level + ", description=" + description + ", duration=" + duration
				+ ", movement=" + movement + ", workout=" + workout + ", sets=" + sets + ", rest=" + rest + "]";
	}
	
	

}
