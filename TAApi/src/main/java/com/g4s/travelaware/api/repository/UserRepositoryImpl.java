package com.g4s.travelaware.api.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.g4s.travelaware.api.repository.UserRepository;
import com.g4s.travelaware.api.repository.utility.HibernateUtility;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.g4s.travelaware.api.domain.ApiUser;

@Repository
@Component
public class UserRepositoryImpl implements UserRepository {
	
	private static final Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public ApiUser findByName(String name){
		Session session = this.sessionFactory.getCurrentSession();		
		ApiUser user = (ApiUser) session.load(ApiUser.class, new String(name));
		logger.info("User loaded successfully, User details="+ user);
		return user;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ApiUser findById(int id){
		Session session = this.sessionFactory.getCurrentSession();		
		ApiUser user = (ApiUser) session.load(ApiUser.class, new Integer(id));
		logger.info("User loaded successfully, User details="+ user);
		return user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public ApiUser addApiUser(ApiUser user){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details="+ user);
		return user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public ApiUser updateApiUser(ApiUser user){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, User Details=" + user);
		return user;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<ApiUser> listApiUser(){
		Session session = this.sessionFactory.getCurrentSession();
		List<ApiUser> userList = session.createQuery("from ApiUser").list();
		for(ApiUser user : userList){
			logger.info("Person List::"+ user );
		}
		return userList;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void removeApiUser(int id){
		Session session = this.sessionFactory.getCurrentSession();
		ApiUser user = (ApiUser) session.load(ApiUser.class, new Integer(id));
		if(null != user){
			session.delete(user);
		}
		logger.info("ApiUser deleted successfully, user details="+  user);
	}

	@Override
	public int removeApiUser() {
		
		Session session = this.sessionFactory.getCurrentSession();
		int totalRecordsDeleted = new HibernateUtility().hqlTruncate("ApiUser", session);
		logger.info("ApiUser deleted " + totalRecordsDeleted +" records successfully");
		return totalRecordsDeleted;
	}
}
