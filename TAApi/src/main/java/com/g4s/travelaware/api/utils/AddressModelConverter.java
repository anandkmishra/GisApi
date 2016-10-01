/**
 * 
 */
package com.g4s.travelaware.api.utils;

import java.io.InvalidObjectException;
import com.g4s.travelaware.api.webapi.model.AddressModel;
import com.g4s.travelaware.api.domain.Address;
import com.g4s.travelaware.api.utils.AddressModelConverter;
/**
 * @author GhostRider
 *
 */
public class AddressModelConverter {
	/**
	 * Returns model
	 * @param user
	 * @return
	 */
	public static AddressModel convertToModel(Address address){
		if(!(null == address)){
			AddressModel model =  new AddressModel();
				model.setId(address.getId());
				model.setCity(address.getCity());
			    model.setApiUser(ApiUserModelConverter.convertToModel(address.getApiUser()));
			    return model;
			}
		throw new org.hibernate.exception.DataException("Address is invalid", null);
	}
	
	/**
	 * Converts model to domain
	 * @param user
	 * @return
	 * @throws InvalidObjectException 
	 */
	public static Address convertToDomain(AddressModel address) throws InvalidObjectException{
		if(!(null == address)){
				Address domain = new Address();
				domain.setId(address.getId());
				domain.setCity(address.getCity());
				domain.setApiUser(ApiUserModelConverter.convertToDomain(address.getApiUser()));
			    return domain;
			}
		//ToDo : convert to custom exception
		throw new InvalidObjectException("Address is invalid");
	}
}
