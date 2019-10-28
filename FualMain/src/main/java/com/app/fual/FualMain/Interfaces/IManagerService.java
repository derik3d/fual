package com.app.fual.FualMain.Interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.CommentDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.PrivateChatDTO;
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
	
	
	public PostDTO commentPost(Long postId, CommentDTO comment);
	public PrivateChatDTO commentPrivateChat(Long privateChatId, CommentDTO comment);
	public CommentDTO likeComment(Long commentId, Long userId);
	public PostDTO likePost(Long postId, Long userId);
	public PrivateChatDTO createPrivateChat(List<Long> userIds);
	
	
	public UserDataDTO getUserDataWithUserId(Long id);
	public boolean followUser(Long follower, Long followed);
	public boolean unFollowUser(Long follower, Long followed);
	
	
}
