package com.app.fual.FualMain.Interfaces;

import org.springframework.stereotype.Service;

import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;

@Service
public interface IManagerService {

	public UserDTO createUser(String name);

	public UserDTO findUserWithName(String name);

	public ChallengeDTO createChallenge(ChallengeDTO challenge);

	public boolean deleteChallengeById(long id);

	public UserDataDTO populateUserDataByName(String userName, UserDataDTO userData);

	public PostDTO createPost(PostDTO post);
	public PostDTO createPostWithUserName(String userName, PostDTO post);
	
}
