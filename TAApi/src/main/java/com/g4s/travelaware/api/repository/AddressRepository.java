/**
 * 
 */
package com.g4s.travelaware.api.repository;


import java.util.List;
import com.g4s.travelaware.api.domain.Address;
//import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

/**
 * @author GhostRider
 *
 */
//@RooJpaRepository(domainType = com.g4s.travelaware.api.domain.Address.class)
public interface AddressRepository {
	Address addAddress(Address address);
	Address updateAddress(Address address);
	List<Address> listAddress();
	void removeAddress(int id);
	Address findById(Integer id);
}
