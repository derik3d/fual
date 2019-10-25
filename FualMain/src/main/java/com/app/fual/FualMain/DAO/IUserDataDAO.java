package com.app.fual.FualMain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.UserDataDTO;

@Repository
public interface IUserDataDAO extends CrudRepository<UserDataDTO, Long>, QueryByExampleExecutor<UserDataDTO>{
	
}
