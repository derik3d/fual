package com.app.fual.FualMain.Interfaces;

public interface IManagerServiceGenerics<T> {

	T createEntity(T entity);
	T findEntity(T entitySample, Long id);

}
