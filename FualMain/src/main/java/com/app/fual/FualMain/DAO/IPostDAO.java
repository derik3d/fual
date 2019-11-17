package com.app.fual.FualMain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.PostDTO;

@Repository
public interface IPostDAO extends CrudRepository<PostDTO, Long>, QueryByExampleExecutor<PostDTO>,
PagingAndSortingRepository<PostDTO,Long>{
	
}
