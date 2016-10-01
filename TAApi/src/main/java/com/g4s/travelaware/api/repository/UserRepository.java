/**
 * 
 */
package com.g4s.travelaware.api.repository;

import java.util.List;

import com.g4s.travelaware.api.domain.ApiUser;

/**
 * @author GhostRider
 *
 */
//@RooJpaRepository(domainType = com.g4s.travelaware.api.domain.ApiUser.class)
public interface UserRepository {
	ApiUser findByName(String name);
	ApiUser findById(int id);
	ApiUser addApiUser(ApiUser user);
	ApiUser updateApiUser(ApiUser user);
	List<ApiUser> listApiUser();
	void removeApiUser(int id);
	int removeApiUser();
}
