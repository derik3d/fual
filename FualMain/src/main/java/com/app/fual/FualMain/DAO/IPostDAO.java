package com.app.fual.FualMain.DAO;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.UserDTO;

@Repository
public interface IPostDAO extends CrudRepository<PostDTO, Long>, QueryByExampleExecutor<PostDTO>,
PagingAndSortingRepository<PostDTO,Long>{

	List<PostDTO> findAllByCreatorIn(Set<UserDTO> follows, Pageable pageable);
	
}
