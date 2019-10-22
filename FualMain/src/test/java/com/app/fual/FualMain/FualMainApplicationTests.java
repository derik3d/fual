package com.app.fual.FualMain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class FualMainApplicationTests {

	
	@Autowired
	IManagerService iManagerService;
	
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
		PostDTO post = new PostDTO();
		post.setDescription("my fisrt post");;
		post.setChallenge(challenge);
		
		iManagerService.createPostWithUserName("barny", post);
		
		System.out.print("done");
		
		
	}
	

}
