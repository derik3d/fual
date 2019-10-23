package com.app.fual.FualMain.Services;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.app.fual.FualMain.DAO.IChallengeDAO;
import com.app.fual.FualMain.DAO.ICommentDAO;
import com.app.fual.FualMain.DAO.IPersonalChatDAO;
import com.app.fual.FualMain.DAO.IPostDAO;
import com.app.fual.FualMain.DAO.IPublicChatDAO;
import com.app.fual.FualMain.DAO.IUserDAO;
import com.app.fual.FualMain.DAO.IUserDataDAO;
import com.app.fual.FualMain.DTO.ChallengeDTO;
import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.PublicChatDTO;
import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;
import com.app.fual.FualMain.Interfaces.IManagerService;
import com.app.fual.FualMain.Interfaces.IManagerServiceGenerics;

@Service
public class ManagerServiceGenerics<T> implements IManagerServiceGenerics<T>{
	
	@Autowired
	IChallengeDAO iChallengeDAO;

	@Autowired
	ICommentDAO iCommentDAO;

	@Autowired
	IPersonalChatDAO iPersonalChatDAO;

	@Autowired
	IPostDAO iPostDAO;

	@Autowired
	IPublicChatDAO iPublicChatDAO;

	@Autowired
	IUserDAO iUserDAO;

	@Autowired
	IUserDataDAO iUserDataDAO;
	
	
	private ArrayList<Object> repos;
	
	@PostConstruct
	public void getIntefaces() {
		
		ArrayList<Object> myInt = new ArrayList<>();

		myInt.add(iChallengeDAO);
		myInt.add(iCommentDAO);
		myInt.add(iPersonalChatDAO);
		myInt.add(iPostDAO);
		myInt.add(iPublicChatDAO);
		myInt.add(iUserDAO);
		myInt.add(iUserDataDAO);

		repos = myInt;
	}
	
	
	@SuppressWarnings("unchecked")
	public CrudRepository<T,Long> getRepoDAO(T sample) {
		CrudRepository<T,Long> res = null;
		for(Object obj: repos) {
			try {
				res = (CrudRepository<T,Long>)obj;
				break;
			}catch(ClassCastException e) {
				//expected class cast exception
			}
			
		}
		return res;
	}
	
	
	@Override
	public T createEntity(T entity){
		return getRepoDAO(entity).save(entity);		
	}
	
	
	@Override
	public T findEntity(T entitySample, Long id){
		Optional<T> foundItem = getRepoDAO(entitySample).findById(id);
		return foundItem.orElseGet(null);		
	}

}
