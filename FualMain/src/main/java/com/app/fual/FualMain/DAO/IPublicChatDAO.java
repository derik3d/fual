package com.app.fual.FualMain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.fual.FualMain.DTO.PublicChatDTO;

@Repository
public interface IPublicChatDAO extends CrudRepository<PublicChatDTO, Long>{
	
}
