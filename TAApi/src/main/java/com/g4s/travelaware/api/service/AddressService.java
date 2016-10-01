/**
 * 
 */
package com.g4s.travelaware.api.service;

import java.io.InvalidObjectException;
import java.util.List;

import com.g4s.travelaware.api.webapi.model.AddressModel;

/**
 * @author GhostRider
 *
 */
public interface AddressService {
	AddressModel findById(int id);
	AddressModel addAddress(AddressModel address) throws InvalidObjectException;
	AddressModel updateAddress(AddressModel address) throws InvalidObjectException;
	List<AddressModel> listAddress();
	boolean removeAddress(int id);
}
