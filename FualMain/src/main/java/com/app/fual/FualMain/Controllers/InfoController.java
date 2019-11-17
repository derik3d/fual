package com.app.fual.FualMain.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.Interfaces.IManagerService;
import com.app.fual.FualMain.UtilEntities.MiniResponse;

@RestController("info")
public class InfoController {


	
	@Autowired
	IManagerService iManagerService;
	
	
	@GetMapping("size/{type}/{id}")
	public MiniResponse getSize(
			@PathVariable(name = "type", required = false) String type,
			@PathVariable(name = "id", required = false) String id
			) {
		
		String returnedQuery = type + "_" + id;
		
		MiniResponse mr = new MiniResponse();
		mr.setRequest(returnedQuery);
		
		switch(type.toLowerCase()) {
		
		
		default:
			return mr;
		}
		
	}
	
}
