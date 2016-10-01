/**
 * 
 */
package com.g4s.travelaware.api.service;

import java.io.InvalidObjectException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.g4s.travelaware.api.repository.AddressRepository;
import com.g4s.travelaware.api.utils.AddressModelConverter;
import com.g4s.travelaware.api.webapi.model.AddressModel;

/**
 * @author GhostRider
 *
 */
@Component
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	private static final Logger logger =  Logger.getLogger(AddressServiceImpl.class);
	/**
	 * 
	 */
	@Override
	public AddressModel findById(int id) {
		return AddressModelConverter.convertToModel(addressRepository.findById(id));
	}

	
	@Override
	public AddressModel addAddress(AddressModel address)
			throws InvalidObjectException {
		try{
			return AddressModelConverter.convertToModel(addressRepository.addAddress(AddressModelConverter.convertToDomain(address)));
		}
		//TODO: to be changed to customized Exceptions
		catch(Throwable e ){
			logger.error(e);
			throw e;
		}
	}

	
	@Override
	public AddressModel updateAddress(AddressModel address)
			throws InvalidObjectException {
		try{
			return AddressModelConverter.convertToModel(addressRepository.updateAddress(AddressModelConverter.convertToDomain(address)));
		}
		//TODO: to be changed to customized Exceptions
		catch(Throwable e ){
			logger.error(e);
			throw e;
		}
	}

	
	@Override
	public List<AddressModel> listAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean removeAddress(int id) {
		boolean success = false;
		try{
			addressRepository.removeAddress(id);
			
			//Check if user exists in the db
			if(addressRepository.findById(id)!= null){
				success = true;
			}
			
			return success;
		}
		catch(Throwable e){
			//TODO: convert to custom exceptions
			logger.error(e);
			throw e;
		}
	}

}
