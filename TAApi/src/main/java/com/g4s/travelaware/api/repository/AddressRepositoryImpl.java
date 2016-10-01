/**
 * 
 */
package com.g4s.travelaware.api.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.g4s.travelaware.api.repository.AddressRepository;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.g4s.travelaware.api.domain.Address;

/**
 * @author GhostRider
 *
 */
@Repository
@Component
public class AddressRepositoryImpl implements AddressRepository {
	private static final Logger logger =  Logger.getLogger(AddressRepositoryImpl.class);

	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param sf
	 */
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	/**
	 * 
	 * @param address
	 */
	public Address addAddress(Address address){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(address);
		logger.info("Address saved successfully, Address Details="+ address);
		return address;
	}
	
	/**
	 * 
	 * @param address
	 */
	public Address updateAddress(Address address){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(address);
		logger.info("address updated successfully, address Details=" + address);
		return address;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Address> listAddress(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Address> addressList = session.createQuery("from Address").list();
		for(Address address : addressList){
			logger.info("address List::"+ address );
		}
		return addressList;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void removeAddress(int id){
		Session session = this.sessionFactory.getCurrentSession();
		Address address = (Address) session.load(Address.class, new Integer(id));
		if(null != address){
			session.delete(address);
		}
		logger.info("address deleted successfully, user details="+  address);
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public Address findById(Integer id){
		Session session = this.sessionFactory.getCurrentSession();		
		Address address = (Address) session.load(Address.class, new Integer(id));
		logger.info("Address loaded successfully, User details="+ address);
		return address;
	}
}
