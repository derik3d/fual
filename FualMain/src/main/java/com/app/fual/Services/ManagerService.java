package com.app.fual.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.fual.FualMain.DAO.IChallengeDAO;
import com.app.fual.FualMain.DAO.ICommentDAO;
import com.app.fual.FualMain.DAO.IPersonalChatDAO;
import com.app.fual.FualMain.DAO.IPostDAO;
import com.app.fual.FualMain.DAO.IPublicChatDAO;
import com.app.fual.FualMain.DAO.IUserDAO;
import com.app.fual.FualMain.DAO.IUserDataDAO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.Interfaces.IManagerService;

@Service
public class ManagerService implements IManagerService{
	
	@Autowired
	IChallengeDAO iChallengeDAO;

	@Autowired
	ICommentDAO iCommentDAO;

	@Autowired
	IPersonalChatDAO iPersonalChatDAO;

	@Autowired
	IPostDAO iPostDAO;

	@Autowired
	IPublicChatDAO iPublicChatDAO;

	@Autowired
	IUserDAO iUserDAO;

	@Autowired
	IUserDataDAO iUserDataDAO;
	
	
	public UserDTO createUser(String name){
		
		UserDTO user = new UserDTO();
		user.setName(name);
		
		iUserDAO.save(user);
		
		return user;
		
	}


	@Override
	public UserDTO findUserWithName(String name) {

		UserDTO user = iUserDAO.findByName(name);

		return user;
	}
	

}
