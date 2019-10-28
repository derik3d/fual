package com.app.fual.FualMain.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.fual.FualMain.DAO.IChallengeDAO;
import com.app.fual.FualMain.DAO.ICommentDAO;
import com.app.fual.FualMain.DAO.IPrivateChatDAO;
import com.app.fual.FualMain.DAO.IPostDAO;
import com.app.fual.FualMain.DAO.IPublicChatDAO;
import com.app.fual.FualMain.DAO.IUserDAO;
import com.app.fual.FualMain.DAO.IUserDataDAO;
import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.CommentDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.PrivateChatDTO;
import com.app.fual.FualMain.DTO.PublicChatDTO;
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
	IPrivateChatDAO iPrivateChatDAO;

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


	@Override
	public PostDTO commentPost(Long postId, CommentDTO comment) {
		
		PublicChatDTO chat = iPostDAO.findById(postId).get().getChat();
		
		comment = iCommentDAO.save(comment);
		
		Set<CommentDTO> comments = chat.getComments();
		comments.add(comment);
		chat.setComments(comments);
		
		Set<UserDTO> participants = chat.getParticipants();
		participants.add(comment.getSender());
		chat.setParticipants(participants);
		
		iPublicChatDAO.save(chat);
		
		return iPostDAO.findById(postId).get();
	}


	@Override
	public PrivateChatDTO commentPrivateChat(Long privateChatId, CommentDTO comment) {
		
		Optional<PrivateChatDTO> chat = iPrivateChatDAO.findById(privateChatId);
		
		comment = iCommentDAO.save(comment);
		
		Set<CommentDTO> comments = chat.get().getComments();
		comments.add(comment);
		chat.get().setComments(comments);
		
		Set<UserDTO> participants = chat.get().getParticipants();
		participants.add(comment.getSender());
		chat.get().setParticipants(participants);
		
		PrivateChatDTO result = iPrivateChatDAO.save(chat.get());
		
		return result;
	}


	@Override
	public CommentDTO likeComment(Long commentId, Long userId) {
		UserDTO liker = iUserDAO.findById(userId).get();
		CommentDTO comment = iCommentDAO.findById(commentId).get();
		Set<UserDTO> likers = comment.getLikedBy();
		likers.add(liker);
		comment.setLikedBy(likers);
		return iCommentDAO.save(comment);
	}


	@Override
	public PostDTO likePost(Long postId, Long userId) {
		UserDTO liker = iUserDAO.findById(userId).get();
		PostDTO post = iPostDAO.findById(postId).get();
		Set<UserDTO> likers = post.getLikedBy();
		likers.add(liker);
		post.setLikedBy(likers);
		return iPostDAO.save(post);
	}


	@Override
	public PrivateChatDTO createPrivateChat(List<Long> userIds) {
		PrivateChatDTO privateChat = new PrivateChatDTO();
		Set<UserDTO> participants = privateChat.getParticipants();
		for(Long userId: userIds) {
			Optional<UserDTO> user = iUserDAO.findById(userId);
			if(user.isPresent())
				participants.add(user.get());
		}
		privateChat.setParticipants(participants);
		return iPrivateChatDAO.save(privateChat);
	}



	@Override
	public UserDataDTO getUserDataWithUserId(Long id) {
		
		UserDTO userExample = new UserDTO();
		userExample.setId(id);
		UserDataDTO dataExample = new UserDataDTO();
		
		UserDataDTO res = iUserDataDAO.findOne(Example.of(dataExample)).get();

		
		return res;
	}

	@Override
	public boolean followUser(Long follower, Long followed) {
		

		UserDTO followerUser = iUserDAO.findById(follower).get();
		UserDTO followedUser = iUserDAO.findById(followed).get();

		UserDataDTO followerUserData = getUserDataWithUserId(follower);
		UserDataDTO followedUserData = getUserDataWithUserId(followed);
		

		followerUserData.getFollows().add(followedUser);
		followedUserData.getFollowedBy().add(followerUser);

		iUserDataDAO.save(followerUserData);
		iUserDataDAO.save(followedUserData);
		
		return true;
	}


	@Override
	public boolean unFollowUser(Long follower, Long followed) {
		

		UserDTO followerUser = iUserDAO.findById(follower).get();
		UserDTO followedUser = iUserDAO.findById(followed).get();

		UserDataDTO followerUserData = getUserDataWithUserId(follower);
		UserDataDTO followedUserData = getUserDataWithUserId(followed);
		

		followerUserData.getFollows().remove(followedUser);
		followedUserData.getFollowedBy().remove(followerUser);

		iUserDataDAO.save(followerUserData);
		iUserDataDAO.save(followedUserData);
		
		return true;
	}
	

}
