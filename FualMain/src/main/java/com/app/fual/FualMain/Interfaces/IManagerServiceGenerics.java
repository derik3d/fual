package com.app.fual.FualMain.Interfaces;

import java.util.List;

public interface IManagerServiceGenerics<T>{

	T createEntity(T entity);
	T findEntity(T entitySample, Long id);
	T updateEntity(Long id, T entity);
	boolean deleteEntity(T entitySample, Long id);
	List<T> getAll(T entitySample);
	
	//NEW METHODS
	List<T> findAllByExample(T exampleObject);
	T findOneByExample(T exampleObject);

}
