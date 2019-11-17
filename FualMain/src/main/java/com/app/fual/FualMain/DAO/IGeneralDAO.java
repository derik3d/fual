package com.app.fual.FualMain.DAO;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.app.fual.FualMain.DTO.ChallengeDTO;

public interface IGeneralDAO<T,K> extends 
CrudRepository<T, K>,
QueryByExampleExecutor<T>,
PagingAndSortingRepository<T,K>{
	
}
