package com.app.fual.FualMain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.CommentDTO;

@Repository
public interface ICommentDAO extends CrudRepository<CommentDTO, Long>, QueryByExampleExecutor<CommentDTO>{
	
}
