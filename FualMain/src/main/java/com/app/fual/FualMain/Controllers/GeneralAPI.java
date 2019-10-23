package com.app.fual.FualMain.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;
import com.app.fual.FualMain.Interfaces.IManagerServiceGenerics;

public abstract class GeneralAPI<T> {
	

	@Autowired
	IManagerServiceGenerics<T> iManagerServiceGenerics;
	
    @GetMapping
    public ResponseEntity<T> getEntity(
      @RequestParam(name="id") Long id) {
      
    	//Class<T> myClass;
    	//T t = myClass.newInstance();
    	
    	T entity = null;
    	
    	System.out.println("first step reached");
    	
    	entity = iManagerServiceGenerics.findEntity( entity , id);
    	
    	if (entity == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(entity,HttpStatus.OK);
	}
	
    @PostMapping
    public ResponseEntity<T> addEntity(
      @RequestBody T entity) {
      
    	entity = iManagerServiceGenerics.createEntity(entity);
    	
    	if (entity == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(entity,HttpStatus.OK);
	}

}
