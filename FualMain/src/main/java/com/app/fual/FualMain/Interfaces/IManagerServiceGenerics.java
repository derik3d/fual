package com.app.fual.FualMain.Interfaces;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.app.fual.FualMain.DTO.UserDataDTO;
import com.app.fual.FualMain.UtilEntities.MiniResponse;

public interface IManagerServiceGenerics<T>{

	T createEntity(T entity);
	T findEntity(T entitySample, Long id);
	T updateEntity(Long id, T entity);
	boolean deleteEntity(T entitySample, Long id);
	List<T> getAll(T entitySample);
	
	//NEW METHODS
	List<T> findAllByExample(T exampleObject);
	T findOneByExample(T exampleObject);
	
	T patchEntity(Long id, T patchEntity);
	
	//new methods 2
	
	MiniResponse sizeOfCollection(T entitySample, Long entityId, String fieldName);
	List<T> findAllByExamplePageable(T exampleObject, Pageable pageable);
	Collection getCollection(T entitySample, Long entityId, String fieldName, int size, int page);

}
