package com.app.fual.FualMain.Services;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;

import org.hibernate.internal.util.beans.BeanInfoHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Service;


import com.app.fual.FualMain.DAO.IChallengeDAO;
import com.app.fual.FualMain.DAO.ICommentDAO;
import com.app.fual.FualMain.DAO.IPrivateChatDAO;
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
import com.app.fual.FualMain.UtilEntities.MiniResponse;

@Service
public class ManagerServiceGenerics<T> implements IManagerServiceGenerics<T>{
	
    final protected ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	IChallengeDAO iChallengeDAO;

	@Autowired
	ICommentDAO iCommentDAO;

	@Autowired
	IPrivateChatDAO iPersonalChatDAO;

	@Autowired
	IPostDAO iPostDAO;

	@Autowired
	IPublicChatDAO iPublicChatDAO;

	@Autowired
	IUserDAO iUserDAO;

	@Autowired
	IUserDataDAO iUserDataDAO;
	
	
	private static ArrayList<Object> repos;
	private static Map<String,CrudRepository> reposMap;
	
	@PostConstruct
	public void getIntefaces() {
		
		ArrayList<Object> myInt = new ArrayList<>();
		reposMap = new HashMap<String , CrudRepository>();
		
		reposMap.put("ChallengeDTO", iChallengeDAO);
		reposMap.put("CommentDTO", iCommentDAO);
		reposMap.put("PrivateChatDTO", iPersonalChatDAO);
		reposMap.put("PostDTO", iPostDAO);
		reposMap.put("PublicChatDTO", iPublicChatDAO);
		reposMap.put("UserDTO", iUserDAO);
		reposMap.put("UserDataDTO", iUserDataDAO);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public CrudRepository<T,Long> getRepoDAO(T sample) {
		CrudRepository<T,Long> res = null;
		
		System.out.println(reposMap.size());
		
		for(Map.Entry<String,CrudRepository> obj: reposMap.entrySet()) {
			
			System.out.println(obj.getKey());
			System.out.println(sample.getClass().getSimpleName());
			
			if(obj.getKey().equals(sample.getClass().getSimpleName())) {
				res = (CrudRepository<T,Long>)obj.getValue();
				break;
			}
		}
		
		System.out.println("returning "+ res);

		
		return res;
	}
	
	
	@Override
	public T createEntity(T entity){
		CrudRepository<T,Long> repo = getRepoDAO(entity);
		return repo.save(entity);
	}
	
	
	@Override
	public T findEntity(T entitySample, Long id){
		CrudRepository<T,Long> repo = getRepoDAO(entitySample);
		
		if(!repo.existsById(id))
			return null;
		
		Optional<T> foundItem = repo.findById(id);
		return foundItem.orElseGet(null);		
	}


	@Override
	public T updateEntity(Long id, T entity) {
		CrudRepository<T,Long> repo = getRepoDAO(entity);
		
		if(!repo.existsById(id))
			return null;


		entity = repo.save(entity);
		
		return entity;
	}


	@Override
	public boolean deleteEntity(T entitySample, Long id) {
		CrudRepository<T,Long> repo = getRepoDAO(entitySample);
		
		if(!repo.existsById(id))
			return false;

		repo.deleteById(id);

		return true;
	}


	@Override
	public List<T> getAll(T entitySample) {
		CrudRepository<T,Long> repo = getRepoDAO(entitySample);
		return (List<T>) repo.findAll();
	}


	@Override
	public List<T> findAllByExample(T exampleObject) {
		@SuppressWarnings("unchecked")
		QueryByExampleExecutor<T> repo = (QueryByExampleExecutor<T>)getRepoDAO(exampleObject);
		return (List<T>) repo.findAll(Example.of(exampleObject));
	}


	@Override
	public T findOneByExample(T exampleObject) {
		@SuppressWarnings("unchecked")
		QueryByExampleExecutor<T> repo = (QueryByExampleExecutor<T>)getRepoDAO(exampleObject);
		return repo.findOne(Example.of(exampleObject)).orElse(null);
	}
	
	
	@Override
	public T patchEntity(Long id, T updateEntity){
		CrudRepository<T,Long> repo = getRepoDAO(updateEntity);
		T existing = repo.findById(id).get();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.map(updateEntity, existing);
		return repo.save(existing);
	
	}


	@Override
	public MiniResponse sizeOfCollection(T entitySample, Long entityId, String fieldName) {
		T entity = findEntity(entitySample, entityId);
		
		MiniResponse mr = new MiniResponse();
		mr.setRequest(entitySample.getClass()+" "+entityId+" "+fieldName);
		
		try {
			
			List<Method> methods = Arrays.asList( entity.getClass().getMethods()) ;
			
			String computedFieldName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);

			
			Predicate<Method> correspondsName = m -> {
				if(m.getName().equals(computedFieldName))
					return true;
				return false;
			};
			
			Optional<Method> foundMethod = methods.stream().filter(correspondsName).findAny();
			
			if(foundMethod.isPresent()) {
				
					Collection myCollection = Collection.class.cast(foundMethod.get().invoke(entity));
					   int size = myCollection.size();
					   mr.setResponse(""+size);
			   
			
			}
			
		
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return mr;
	}
    



	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByExamplePageable(T exampleObject, Pageable pageable) {
		@SuppressWarnings("unchecked")
		QueryByExampleExecutor<T> repo = (QueryByExampleExecutor<T>)getRepoDAO(exampleObject);
		
		return (List<T>) repo.findAll(Example.of(exampleObject), pageable);
	}


}
