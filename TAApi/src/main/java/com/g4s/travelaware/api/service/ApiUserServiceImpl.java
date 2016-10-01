/**
 * 
 */
package com.g4s.travelaware.api.service;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.g4s.travelaware.api.domain.ApiUser;
import com.g4s.travelaware.api.repository.AddressRepositoryImpl;
import com.g4s.travelaware.api.repository.UserRepository;
import com.g4s.travelaware.api.utils.ApiUserModelConverter;
import com.g4s.travelaware.api.webapi.model.ApiUserModel;

/**
 * @author GhostRider
 *
 */
@Component
public class ApiUserServiceImpl implements ApiUserService{

	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger =  Logger.getLogger(ApiUserServiceImpl.class);
	
	@Override
	public ApiUserModel findByName(String name) {
		return ApiUserModelConverter.convertToModel( userRepository.findByName(name));
	}

	@Override
	public ApiUserModel findById(int id) {
		return ApiUserModelConverter.convertToModel( userRepository.findById(id));
	}

	@Override
	public ApiUserModel addApiUser(ApiUserModel user) throws InvalidObjectException {
		try {
			return ApiUserModelConverter.convertToModel( userRepository.addApiUser(ApiUserModelConverter.convertToDomain(user)));
		} catch (InvalidObjectException e) {
			//TODO: Create custom exceptions and throw it
			logger.error(e);
			throw e;
		}
		catch (Throwable e) {
			//TODO: Create custom exceptions and throw it
			logger.error(e);
			throw e;
		}
	}

	@Override
	//@Transactional
	public ApiUserModel updateApiUser(ApiUserModel user) throws InvalidObjectException {
		try {
			return ApiUserModelConverter.convertToModel( userRepository.updateApiUser(ApiUserModelConverter.convertToDomain(user)));
		} catch (InvalidObjectException e) {
			//TODO: Create custom exceptions and throw it
			logger.error(e);
			throw e;
		}
	}

	@Override
	public List<ApiUserModel> listApiUser() {
		
		//TODO: convert it to Java 8 stream
		List<ApiUserModel> models = new ArrayList<ApiUserModel>();
		for(ApiUser user: userRepository.listApiUser()){
			models.add(ApiUserModelConverter.convertToModel(user));
		}
		
//		return userRepository.listApiUser().forEach(user->
//		{
//			ApiUserModel model = ApiUserModelConverter.convertToModel(user);
//			return model;
//		}
//				);
		
		return models;
	}

	@Override
	public boolean removeApiUser(int id) {
		boolean success = false;
		userRepository.removeApiUser(id);
		
		//Check if user exists in the db
		if(userRepository.findById(id)!= null){
			success = true;
		}
		
		return success;
	}

	@Override
	public boolean isUserExist(ApiUserModel user) {
		if(userRepository.findByName(user.getFname()) != null ){
			return true;
		}
		else return false;
	}

	@Override
	public int removeApiUser() {
		
		return userRepository.removeApiUser();
	}

}
