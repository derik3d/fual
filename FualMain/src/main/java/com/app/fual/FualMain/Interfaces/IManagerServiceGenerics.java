package com.app.fual.FualMain.Interfaces;

import java.util.List;

public interface IManagerServiceGenerics<T> {

	T createEntity(T entity);
	T findEntity(T entitySample, Long id);
	T updateEntity(Long id, T entity);
	boolean deleteEntity(Long id);
	List<T> getAll();

}
