package com.app.fual.FualMain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.CommentDTO;
import com.app.fual.FualMain.DTO.PrivateChatDTO;
import com.app.fual.FualMain.DTO.PublicChatDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;
import com.app.fual.FualMain.Interfaces.IManagerServiceGenerics;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class FualMainApplicationTests {


	@Autowired
	IManagerService iManagerService;

	@Autowired
	IManagerServiceGenerics<UserDTO> iManagerServiceGenericsUserDTO;
	
	@Autowired
	IManagerServiceGenerics<ChallengeDTO> iManagerServiceGenericsChallengeDTO;
	
	@Autowired
	IManagerServiceGenerics<UserDataDTO> iManagerServiceGenericsUserDataDTO;
	
	@Autowired
	IManagerServiceGenerics<PostDTO> iManagerServiceGenericsPostDTO;
	
	@Autowired
	IManagerServiceGenerics<PrivateChatDTO> iManagerServiceGenericsPrivateChatDTO;
	
	@Autowired
	IManagerServiceGenerics<PublicChatDTO> iManagerServiceGenericsPublicChatDTO;
	
	@Autowired
	IManagerServiceGenerics<CommentDTO> iManagerServiceGenericsCommentDTO;
	
	@Test
	public void usercreation() {
		

		
		//users creation
		System.out.println(iManagerService.createUser("alfredito777"));
		
		
		iManagerService.createUser("barny");
		iManagerService.createUser("Alfred");
		
		
		
		//users data association
		UserDataDTO userData = new UserDataDTO();
		userData.setAge(15);
		userData.setLevel(21);
		
		
		UserDataDTO userData22 = new UserDataDTO();
		userData.setAge(123);
		userData.setLevel(21233);

		iManagerService.populateUserDataByName("barny",  userData);
		iManagerService.populateUserDataByName("alfred",  userData22);
				
		
		
		//create some challenges
		ChallengeDTO challenge = new ChallengeDTO();
		challenge.setLevel("very hard");
		challenge.setDescription("1000 push ups");
		challenge.setDuration("2 minutes");
		
		challenge = iManagerService.createChallenge(challenge);
		
		
		//users making posts
		//but first create the public chat assoc to this post
		
		
		//iManagerService.createPostWithUserName("barny", post);

		
		
		//iManagerService.createPostWithUserName("barny", post);
		
		//System.out.print("done");
		
		
	}
	
	
	@Test
	public void genericsTest(){
		

		//-----------------------------
		//Creating users
		//-----------------------------

		String userName1= "pedrito";
		String userName2= "juanito";
		String userName3= "pelafustanito";
		String userName4= "barnypeque";
		String userName5= "barnygrande";
		
		UserDTO userr1 = new UserDTO();
		userr1.setName(userName1);
		System.out.println(iManagerServiceGenericsUserDTO.createEntity(userr1));

		UserDTO userr2 = new UserDTO();
		userr2.setName(userName2);
		System.out.println(iManagerServiceGenericsUserDTO.createEntity(userr2));

		UserDTO userr3 = new UserDTO();
		userr3.setName(userName3);
		System.out.println(iManagerServiceGenericsUserDTO.createEntity(userr3));

		UserDTO userr4 = new UserDTO();
		userr4.setName(userName4);
		System.out.println(iManagerServiceGenericsUserDTO.createEntity(userr4));

		UserDTO userr5 = new UserDTO();
		userr5.setName(userName5);
		System.out.println(iManagerServiceGenericsUserDTO.createEntity(userr5));

		//-----------------------------
		//Challenges
		//-----------------------------

		ChallengeDTO challenge1 = new ChallengeDTO();
		challenge1.setLevel("2");
		challenge1.setDuration("2 horas");
		challenge1.setDescription("1000 push ups straight");
		System.out.println(iManagerServiceGenericsChallengeDTO.createEntity(challenge1));
		
		ChallengeDTO challenge2 = new ChallengeDTO();
		challenge2.setDescription("the best trining");
		System.out.println(iManagerServiceGenericsChallengeDTO.createEntity(challenge2));
		
		ChallengeDTO challenge3 = new ChallengeDTO();
		challenge3.setDuration("20 minutos");
		System.out.println(iManagerServiceGenericsChallengeDTO.createEntity(challenge3));
		
		//-----------------------------
		//Associating users to UserDat
		//-----------------------------
		
		//########MISSING FIND USER BY NAME
		
		UserDTO userObtained1 = iManagerServiceGenericsUserDTO.findEntity(userr1, 1l);
		
		UserDataDTO userData1 = new UserDataDTO();
		userData1.setUser(userObtained1);
		userData1.setAge(17);
		userData1.setUserInfo("very good to eat, very bad to exercise");
		userData1.setCity("Bogota");
		userData1.setCountry("Colombia");
		userData1.setGender("man");
		userData1.setLevel(20);
		userData1.setProfileImageLink("http://mi.fotico.com/foto1");
		userData1.setTag("@caradezanahoria");

		
		Set<UserDTO> followedBy = new HashSet<>();
		followedBy.add(iManagerServiceGenericsUserDTO.findEntity(userr1, 2l));
		followedBy.add(iManagerServiceGenericsUserDTO.findEntity(userr1, 3l));
		
		Set<UserDTO> follows = new HashSet<>();
		follows.add(iManagerServiceGenericsUserDTO.findEntity(userr1, 3l));
		follows.add(iManagerServiceGenericsUserDTO.findEntity(userr1, 4l));
		
		Set<UserDTO> blockedUsers = new HashSet<>();
		blockedUsers.add(iManagerServiceGenericsUserDTO.findEntity(userr1, 2l));
		
		userData1.setBlockedUsers(blockedUsers);
		userData1.setFollowedBy(followedBy);
		userData1.setFollows(follows);
		
		System.out.println(iManagerServiceGenericsUserDataDTO.createEntity(userData1));

		
		//follows unfollows
		
		UserDTO userObtained3 = iManagerServiceGenericsUserDTO.findEntity(userr1, 3l);
		
		UserDataDTO userData3 = new UserDataDTO();
		userData3.setUser(userObtained3);
		userData3.setAge(17);
		userData3.setUserInfo("very good se");
		userData3.setCity("ta");
		userData3.setCountry("Coloa");
		userData3.setGender("mn");
		userData3.setLevel(2);
		userData3.setProfileImageLink("http://mico.com/foto1");
		userData3.setTag("@cahoria");
		
		
		System.out.println(iManagerServiceGenericsUserDataDTO.createEntity(userData3));


		iManagerService.followUser(1l, 1l);
		iManagerService.followUser(3l, 1l);
		iManagerService.unFollowUser(3l, 1l);
		
		
		
		
		//AUTO userData1.setPersonalChats(personalChats);
		//AUTO userData1.setPostsCreated(postsCreated);
		
		

		//-----------------------------
		//talk to someone with a private chat
		//-----------------------------
		
		//user1 and user2 wanna talk
		
		PrivateChatDTO chat1 = new PrivateChatDTO();
		chat1.getParticipants().add(userr4);
		chat1.getParticipants().add(userr5);
		
		CommentDTO commentPriv1 = new CommentDTO();
		commentPriv1.setSender(userr4);
		commentPriv1.setMessage("hello my friend");
		
		commentPriv1 = iManagerServiceGenericsCommentDTO.createEntity(commentPriv1);
		
		
		chat1.getComments().add(commentPriv1);
		System.out.println(chat1 = iManagerServiceGenericsPrivateChatDTO.createEntity(chat1));
		
		CommentDTO commentPriv2 = new CommentDTO();
		commentPriv2.setSender(userr4);
		commentPriv2.setMessage("hello buddy");
		
		commentPriv2 = iManagerServiceGenericsCommentDTO.createEntity(commentPriv2);
		
		
		chat1.getComments().add(commentPriv2);
		System.out.println(chat1 = iManagerServiceGenericsPrivateChatDTO.updateEntity(chat1.getId(), chat1));


		//-----------------------------
		//Create and like a post with public chat
		//-----------------------------

		//find user
		UserDTO userObtained2 = iManagerServiceGenericsUserDTO.findEntity(userr1, 2l);
		
		//get a challenge
		ChallengeDTO postChallenge = new ChallengeDTO();
		postChallenge = iManagerServiceGenericsChallengeDTO.findEntity(postChallenge, 3l);
		
		//create the public chat that will be used for the chat
		PublicChatDTO postChat = new PublicChatDTO();
		System.out.println(iManagerServiceGenericsPublicChatDTO.createEntity(postChat));

		//fill must fields
		PostDTO post = new PostDTO();
		post.setCreator(userObtained2);
		post.setDescription("my first post");;
		post.setChallenge(postChallenge);
		post.setChat(postChat);
		
		List<String> images = post.getImageLink();
		images.add("http://mi.fotico.com/foto2");
		images.add("http://mi.fotico.com/foto3");
		images.add("http://mi.fotico.com/foto4");
		images.add("http://mi.fotico.com/foto5");
		
		
		//create the post
		System.out.println(post = iManagerServiceGenericsPostDTO.createEntity(post));
		
		Set<UserDTO> likedByPost = post.getLikedBy();
		likedByPost.add(userr3);
		likedByPost.add(userr4);
		likedByPost.add(userr5);
		
		Set<String> tagsPost = post.getTags();
		tagsPost.add("@Cool");
		tagsPost.add("@Boring");
		tagsPost.add("@hello");
		
		
		System.out.println(post = iManagerServiceGenericsPostDTO.updateEntity(post.getId(),post));


		

		//-----------------------------
		//coments on post and liking to comment
		//-----------------------------
		
		PostDTO postRetrieved = new PostDTO();
		
		
		//starting having a post
		System.out.println(postRetrieved = iManagerServiceGenericsPostDTO.findEntity(postRetrieved, 1l));
		
		//get the chat
		PublicChatDTO postChatRetrieved = postRetrieved.getChat();
		
		//add comments

		UserDTO userComment3 = iManagerServiceGenericsUserDTO.findEntity(userr1, 3l);
		UserDTO userComment4 = iManagerServiceGenericsUserDTO.findEntity(userr1, 4l);
		UserDTO userComment5 = iManagerServiceGenericsUserDTO.findEntity(userr1, 5l);

		CommentDTO comment1 = new CommentDTO();
		comment1.setSender(userComment3);
		comment1.setMessage("this post sucks");
		
		//liking
		Set<UserDTO> likedBy = comment1.getLikedBy();
		likedBy.add(userComment4);
		likedBy.add(userComment5);
		
		
		comment1 = iManagerServiceGenericsCommentDTO.createEntity(comment1);
		
		CommentDTO comment2 = new CommentDTO();
		comment2.setSender(userComment4);
		comment2.setMessage("love this");
		
		comment2 = iManagerServiceGenericsCommentDTO.createEntity(comment2);
		
		CommentDTO comment3 = new CommentDTO();
		comment3.setSender(userComment3);
		comment3.setMessage("hate this post");
		
		comment3 = iManagerServiceGenericsCommentDTO.createEntity(comment3);
		
		CommentDTO comment4 = new CommentDTO();
		comment4.setSender(userComment5);
		comment4.setMessage("this post is old");
		
		comment4 = iManagerServiceGenericsCommentDTO.createEntity(comment4);
		
		CommentDTO comment5 = new CommentDTO();
		comment5.setSender(userComment3);
		comment5.setMessage("this post id good");
		
		comment5 = iManagerServiceGenericsCommentDTO.createEntity(comment5);
		
		Set<CommentDTO> comments = postChatRetrieved.getComments();
		comments.add(comment1);
		comments.add(comment2);
		comments.add(comment3);
		comments.add(comment4);
		comments.add(comment5);
		
		Set<UserDTO> participants = postChatRetrieved.getParticipants();
		participants.add(userComment4);
		participants.add(userComment5);
		participants.add(userComment3);//carefull with duplicate entries
				
		postChatRetrieved.setComments(comments);
		
		//ease the element collection insertion
		//add easy specific querys
		
		iManagerServiceGenericsPublicChatDTO.updateEntity(postChatRetrieved.getId(), postChatRetrieved);
		

		String numFollowers = iManagerServiceGenericsUserDataDTO.sizeOfCollection(userData1, userData1.getId(), "followedBy").getResponse();
		
		if(numFollowers instanceof Object)
			System.out.print("numberOfFollowers " + numFollowers );
		else
			System.out.print("NOPE");
		

		Collection coll = iManagerServiceGenericsUserDataDTO.getCollection(userData1, userData1.getId(), "followedBy", 1 , 0);
		
		if(coll instanceof Object)
			System.out.print("1 0 " + coll );
		else
			System.out.print("NOPE");


		 coll = iManagerServiceGenericsUserDataDTO.getCollection(userData1, userData1.getId(), "followedBy", 1 , 1);
		
		if(coll instanceof Object)
			System.out.print("1 1 " + coll );
		else
			System.out.print("NOPE");



		
		 coll = iManagerServiceGenericsUserDataDTO.getCollection(userData1, userData1.getId(), "followedBy", 2 , 0);
		
		if(coll instanceof Object)
			System.out.print("2 0 " + coll );
		else
			System.out.print("NOPE");

		
		 coll = iManagerServiceGenericsUserDataDTO.getCollection(userData1, userData1.getId(), "followedBy", -1 , 0);
		
		if(coll instanceof Object)
			System.out.print("-1 0 " + coll );
		else
			System.out.print("NOPE");

		
		System.out.print("");
		//
	}

}
