package com.app.fual.FualMain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.UserDTO;

@Repository
public interface IUserDAO extends CrudRepository<UserDTO, Long>{

	UserDTO findByName(String name);
	
}
