package com.app.fual.FualMain.Controllers;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;
import com.app.fual.FualMain.Interfaces.IManagerServiceGenerics;

public abstract class GeneralAPI<T> {
	

	@Autowired
	IManagerServiceGenerics<T> iManagerServiceGenerics;
	
	private Class<T> type;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void initialize()
	{
		ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
		type= (Class<T>) superClass.getActualTypeArguments()[0];
	}

    @GetMapping
    public ResponseEntity<List<T>> getAllEntities() throws InstantiationException, IllegalAccessException{
    	
    	T entitySample = type.newInstance();
    	
    	List<T> entities = iManagerServiceGenerics.getAll(entitySample);
    	
    	if (entities == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(entities,HttpStatus.OK);
    }
	
	
    @GetMapping("{id}")
    public ResponseEntity<T> getEntity(
      @PathVariable(name="id") Long id) throws InstantiationException, IllegalAccessException {
    	    	
		T entitySample = type.newInstance();
    	
    	entitySample = iManagerServiceGenerics.findEntity( entitySample , id);
    	
    	if (entitySample == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(entitySample,HttpStatus.OK);
	}
	
    @PostMapping
    public ResponseEntity<T> addEntity(
      @RequestBody T entity) {
      
    	entity = iManagerServiceGenerics.createEntity(entity);
    	
    	if (entity == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(entity,HttpStatus.OK);
	}
    
    @PutMapping("{id}")
    public ResponseEntity<T> update(
    	      @PathVariable(name="id") Long id, @RequestBody T entity) {
    	entity = iManagerServiceGenerics.updateEntity(id, entity);
    	
    	if (entity == null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<>(entity,HttpStatus.OK);
    }
    
    @SuppressWarnings("rawtypes")
	@DeleteMapping
    public ResponseEntity delete(
  	      @PathVariable(name="id") Long id) throws InstantiationException, IllegalAccessException {
    	
    	T entitySample = type.newInstance();
    	
    	boolean result = iManagerServiceGenerics.deleteEntity(entitySample, id);
  	
    	if (result)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	else return ResponseEntity.ok(HttpStatus.OK);
  }
    

}
