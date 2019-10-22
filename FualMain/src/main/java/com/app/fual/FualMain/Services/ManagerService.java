package com.app.fual.FualMain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.fual.FualMain.DAO.IChallengeDAO;
import com.app.fual.FualMain.DAO.ICommentDAO;
import com.app.fual.FualMain.DAO.IPersonalChatDAO;
import com.app.fual.FualMain.DAO.IPostDAO;
import com.app.fual.FualMain.DAO.IPublicChatDAO;
import com.app.fual.FualMain.DAO.IUserDAO;
import com.app.fual.FualMain.DAO.IUserDataDAO;
import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;

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
		return iUserDAO.findByName(name);
	}


	@Override
	public ChallengeDTO createChallenge(ChallengeDTO challenge) {
		return iChallengeDAO.save(challenge);
	}

	@Override
	public boolean deleteChallengeById(long id) {
		iChallengeDAO.deleteById(id);
		return true;
	}


	@Override
	public UserDataDTO populateUserDataByName(String userName, UserDataDTO userData) {
		UserDTO user = findUserWithName(userName);
		userData.setUser(user);
		return iUserDataDAO.save(userData);
	}


	@Override
	public PostDTO createPost(PostDTO post) {
		return iPostDAO.save(post);
	}


	@Override
	public PostDTO createPostWithUserName(String userName, PostDTO post) {
		UserDTO user = findUserWithName(userName);
		post.setCreator(user);
		return iPostDAO.save(post);
	}
	

}
