package com.app.fual.FualMain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.PrivateChatDTO;

@Repository
public interface IPersonalChatDAO extends CrudRepository<PrivateChatDTO, Long>, QueryByExampleExecutor<PrivateChatDTO>{
	
}
