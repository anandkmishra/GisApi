/**
 * 
 */
package com.g4s.travelaware.api.utils;
import java.io.InvalidObjectException;

import com.g4s.travelaware.api.webapi.model.ApiUserModel;
import com.g4s.travelaware.api.domain.ApiUser;
import com.g4s.travelaware.api.domain.Address;
import com.g4s.travelaware.api.utils.AddressModelConverter;

/**
 * @author GhostRider
 *
 */
public class ApiUserModelConverter {
	/**
	 * Returns model
	 * @param user
	 * @return
	 */
	public static ApiUserModel convertToModel(ApiUser user){
		if(!(null == user)){
				ApiUserModel model =  new ApiUserModel();
				model.setId(user.getId());
				model.setFname(user.getFname());
			    model.setLname(user.getLname());
			    model.setSubscriptionId(user.getSubscriptionId());
			    model.setIsActive(user.getIsActive());
			    model.setAddress(AddressModelConverter.convertToModel(user.getAddress()));
			    return model;
			}
		throw new org.hibernate.exception.DataException("ApiUser is invalid", null);
	}
	
	/**
	 * Converts model to domain
	 * @param user
	 * @return
	 * @throws InvalidObjectException 
	 */
	public static ApiUser convertToDomain(ApiUserModel user) throws InvalidObjectException{
		if(!(null == user)){
				ApiUser domian =  new ApiUser();
				domian.setId(user.getId());
				domian.setFname(user.getFname());
				domian.setLname(user.getLname());
				domian.setSubscriptionId(user.getSubscriptionId());
				domian.setIsActive(user.getIsActive());
				domian.setAddress(AddressModelConverter.convertToDomain(user.getAddress()));
			    return domian;
			}
		//ToDo : convert to custom exception
		throw new InvalidObjectException("ApiUser is invalid");
	}
}
