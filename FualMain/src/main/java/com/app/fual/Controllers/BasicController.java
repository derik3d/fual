package com.app.fual.Controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.Interfaces.IManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BasicController {
	
	@Autowired
	IManagerService iManagerService;
	

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
    		value="createUserWithName/"
    		)
    
    public  ResponseEntity<UserDTO>  createUserWithName(@RequestParam(name="name", required=true) String name){
    	
    	UserDTO res = iManagerService.createUser(name);
    	
    	if (res == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
    
    
    @RequestMapping(
    		value="getUserIdWithName/"
    		)
    
    public  ResponseEntity<UserDTO>  getUserProfileById(@RequestParam(name="name", required=true) String name){
    	
    	UserDTO res = iManagerService.findUserWithName(name);
    	
    	if (res == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		
		return new ResponseEntity<>(res,HttpStatus.OK);
    	
    }
    
    
    

}