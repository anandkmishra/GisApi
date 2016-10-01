/**
 * 
 */
package com.g4s.travelaware.api.service;

import java.io.InvalidObjectException;
import java.util.List;

import com.g4s.travelaware.api.domain.ApiUser;
import com.g4s.travelaware.api.webapi.model.ApiUserModel;

/**
 * @author GhostRider
 *
 */
//@RooService(domainTypes = { com.g4s.travelaware.api.domain.ApiUser.class })
public interface ApiUserService {
	
	ApiUserModel findByName(String name);
	ApiUserModel findById(int id);
	ApiUserModel addApiUser(ApiUserModel user) throws InvalidObjectException;
	ApiUserModel updateApiUser(ApiUserModel user) throws InvalidObjectException;
	List<ApiUserModel> listApiUser();
	boolean removeApiUser(int id);
	boolean isUserExist(ApiUserModel user);
	int removeApiUser();
}
