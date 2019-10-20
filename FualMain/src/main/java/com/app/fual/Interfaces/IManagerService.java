package com.app.fual.Interfaces;

import com.app.fual.FualMain.DTO.UserDTO;

public interface IManagerService {

	public UserDTO createUser(String name);

	public UserDTO findUserWithName(String name);
	
}
