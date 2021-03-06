package com.app.fual.FualMain.Controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.CommentDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.PrivateChatDTO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("customQuery")
public class CustomController {
	
	@Autowired
	IManagerService iManagerService;
	

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    
    @RequestMapping(value = "/getTestJson",
    	      produces = MediaType.APPLICATION_JSON_VALUE
    	      )
    public String home(@RequestParam(name="name", required=false, defaultValue="no") String name) {
    	
        return "json/"+name+".json";

    }
    
    
    
    
    @RequestMapping(
    		value="/createUserByName"
    		)
    
    public  ResponseEntity<UserDTO>  createUserByName(@RequestParam(name="name", required=true) String name){
    	
    	UserDTO res = iManagerService.createUser(name);
    	
    	if (res == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
    
    
    @RequestMapping(
    		value="/getUserByName/"
    		)
    
    public  ResponseEntity<UserDTO>  getUserByName(@RequestParam(name="name", required=true) String name){
    	
    	UserDTO res = iManagerService.findUserWithName(name);
    	
    	if (res == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
    
    //********
    @RequestMapping(
    		value="/getUserDataByUserId/"
    		)
    
    public  ResponseEntity<UserDataDTO>  getUserDataByUserId(@RequestParam(name="userid", required=true) Long userid){
    	
    	UserDataDTO res = iManagerService.getUserDataWithUserId(userid);
    	
    	if (res == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
    
    
    @GetMapping(
    		value="/getUserDataById/{id}"
    		)
    
    public  ResponseEntity<UserDataDTO>  getUserDataById(@PathVariable(name="id", required=true) Long id){
    	
    	UserDataDTO res = iManagerService.getUserDataWithUserId(id);
    	
    	if (res == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
    
    @PostMapping("createChallenge")
    public ResponseEntity postChallenge(
      @RequestBody ChallengeDTO challenge) {
      
		challenge = iManagerService.createChallenge(challenge);
        
    	if (challenge == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(challenge,HttpStatus.OK);
	}
    
    
    @PostMapping("createPost")
    public ResponseEntity postPost(
      @RequestBody PostDTO post) {
      
		post = iManagerService.createPost(post);
    	
    	if (post == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(post,HttpStatus.OK);
    	
    }
    
    //****************************************************************************
    
    @PostMapping("commentPost/{id}")
    public ResponseEntity<PostDTO> commentPost(
    		@PathVariable(name="id") Long postId,
    		@RequestBody CommentDTO comment) {
      
		PostDTO post = iManagerService.commentPost(postId, comment);
    	
    	if (post == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(post,HttpStatus.OK);
    	
    }
    
    @PostMapping("commentPostGetComment/{id}")
    public ResponseEntity<CommentDTO> commentPostGetComment(
    		@PathVariable(name="id") Long postId,
    		@RequestBody CommentDTO comment) {
      
		CommentDTO post = iManagerService.commentPostGetComment(postId, comment);
    	
    	if (post == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(post,HttpStatus.OK);
    	
    }
    
    @PostMapping("commentPrivateChat/{id}")
    public ResponseEntity<PrivateChatDTO> commentPrivateChat(
    		@PathVariable(name="id") Long privateChatId,
    		@RequestBody CommentDTO comment) {
      
		PrivateChatDTO chat = iManagerService.commentPrivateChat(privateChatId, comment);
    	
    	if (chat == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(chat,HttpStatus.OK);
    	
    }
    

    
    @PostMapping("likeComment/{commentId}/{userId}")
    public ResponseEntity<CommentDTO> likeComment(
    		@PathVariable(name="commentId") Long commentId,
    		@PathVariable(name="userId") Long userId) {
      
		CommentDTO comment = iManagerService.likeComment(commentId, userId);
    	
    	if (comment == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(comment,HttpStatus.OK);
    	
    }
    

    
    @PostMapping("likePost/{postId}/{userId}")
    public ResponseEntity<PostDTO> likePost(
    		@PathVariable(name="postId") Long postId,
    		@PathVariable(name="userId") Long userId) {
      
		PostDTO post = iManagerService.likePost(postId, userId);
    	
    	if (post == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(post,HttpStatus.OK);
    	
    }
    

    
    @PostMapping("unlikeComment/{commentId}/{userId}")
    public ResponseEntity<CommentDTO> unlikeComment(
    		@PathVariable(name="commentId") Long commentId,
    		@PathVariable(name="userId") Long userId) {
      
		CommentDTO comment = iManagerService.unlikeComment(commentId, userId);
    	
    	if (comment == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(comment,HttpStatus.OK);
    	
    }
    

    
    @PostMapping("unlikePost/{postId}/{userId}")
    public ResponseEntity<PostDTO> unlikePost(
    		@PathVariable(name="postId") Long postId,
    		@PathVariable(name="userId") Long userId) {
      
		PostDTO post = iManagerService.unlikePost(postId, userId);
    	
    	if (post == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(post,HttpStatus.OK);
    	
    }
    
    @PostMapping("createPrivateChat")
    public ResponseEntity<PrivateChatDTO> createPrivateChat(
    		@RequestBody List<Long> userIds) {
      
		PrivateChatDTO chat = iManagerService.createPrivateChat(userIds);
    	
    	if (chat == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(chat,HttpStatus.OK);
    	
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping("followUser/{follower}/{followed}")
    public ResponseEntity follow(
    		@PathVariable(name="follower") Long follower,
			@PathVariable(name="followed") Long followed) {
      
		boolean res = iManagerService.followUser(follower, followed);
    	
    	if (res)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return ResponseEntity.ok(HttpStatus.OK);
    	
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping("unFollowUser/{follower}/{followed}")
    public ResponseEntity unFollow(
    		@PathVariable(name="follower") Long follower,
			@PathVariable(name="followed") Long followed) {
      
		boolean res = iManagerService.unFollowUser(follower, followed);
    	
    	if (res)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return ResponseEntity.ok(HttpStatus.OK);
    	
    }
    

    @GetMapping(
    		value="/postsFeedForUser/{id}/{howMany}/{page}"
    		)
    
    public  ResponseEntity<List<PostDTO>>  getPostsFeedForUser(
    		@PathVariable(name="id", required=true) Long id,
    		@PathVariable(name="howMany", required=true) int howMany,
    		@PathVariable(name="page", required=true) int page
    		){
    	
    	List<PostDTO> res = iManagerService.getPostsFeedForUser(id, howMany, page);
    	
    	if (res == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
	
	
	
    
    
    @GetMapping(
    		value="/getRecommendedUsers/{id}"
    		)
    
    public  ResponseEntity<List<Long>>  getRecommendedUsers(@PathVariable(name="id", required=true) Long id){
    	
    	List<Long> res = iManagerService.getRecommendedUsers(id);
    	
    	if (res == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
	

}
