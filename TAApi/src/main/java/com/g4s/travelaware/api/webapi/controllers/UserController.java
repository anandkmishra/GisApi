/**
 * 
 */
package com.g4s.travelaware.api.webapi.controllers;


import io.swagger.annotations.ApiParam;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InvalidObjectException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.g4s.travelaware.api.webapi.model.ApiUserModel;

/**
 * @author GhostRider
 *
 */
@Api(value = "users", description = "CRUD operations on ApiUser", position = 1)
public class UserController extends ApiController {
	//-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<ApiUserModel>> listAllUsers(HttpServletResponse response, HttpServletRequest request ) {
        List<ApiUserModel> users = userService.listApiUser();
        if(users.isEmpty()){
            return new ResponseEntity<List<ApiUserModel>>(HttpStatus.NO_CONTENT);
            //TODO: discuss if the status has to be HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ApiUserModel>>(users, HttpStatus.OK);
    }
 
 
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiUserModel> getUser(@ApiParam(required = true)  @PathVariable("id") int id,
    		HttpServletResponse response, HttpServletRequest request ) {
        System.out.println("Fetching User with id " + id);
        ApiUserModel user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<ApiUserModel>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ApiUserModel>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public ResponseEntity<ApiUserModel> createUser(@RequestBody ApiUserModel user,    UriComponentsBuilder ucBuilder,
    		HttpServletResponse response, HttpServletRequest request ) {
        
    	//TODO: Add logic for request filtering
    	
    	//TODO: Add logic for Model validation
    	//setUpRequest( request);

		//validateOrderModel();
    	
    	if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getFname() + " already exist");
            return new ResponseEntity<ApiUserModel>(HttpStatus.CONFLICT);
        }
 
        try {
			userService.addApiUser(user);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<ApiUserModel>(headers, HttpStatus.CREATED);
		} catch (InvalidObjectException e) {
			//TODO: convert to custom error
			return new ResponseEntity<ApiUserModel>(HttpStatus.EXPECTATION_FAILED);
		}
 
        
    }
 
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public ResponseEntity<ApiUserModel> updateUser(
    		@ApiParam(required = true) @PathVariable("id") int id, 
    		@RequestBody ApiUserModel user,HttpServletResponse response, HttpServletRequest request 
    		 ) {
    	ApiUserModel currentUser = userService.findById(id);
         
        if (currentUser==null) {
            
            return new ResponseEntity<ApiUserModel>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setFname(user.getFname());
        currentUser.setLname(user.getLname());
        currentUser.setIsActive(user.getIsActive());
        currentUser.setAddress(user.getAddress());
         
        try {
			userService.updateApiUser(currentUser);
			return new ResponseEntity<ApiUserModel>(currentUser, HttpStatus.OK);
		} catch (InvalidObjectException e) {
			//TODO: convert to custom error
			return new ResponseEntity<ApiUserModel>(currentUser, HttpStatus.EXPECTATION_FAILED);
		}
        
    }
 
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public ResponseEntity<ApiUserModel> deleteUser(@ApiParam(required = true) @PathVariable("id") int id,
    		HttpServletResponse response, HttpServletRequest request ) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        ApiUserModel user = userService.findById(id);
        if (user == null) {
            
            return new ResponseEntity<ApiUserModel>(HttpStatus.NOT_FOUND);
        }
 
        userService.removeApiUser(id);
        return new ResponseEntity<ApiUserModel>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public ResponseEntity<String> deleteAllUsers(HttpServletResponse response, HttpServletRequest request ) {
        System.out.println("Deleting All Users");
 
        int totalRecordsDeleted = userService.removeApiUser();
        return new ResponseEntity<String>(totalRecordsDeleted + " user records were deleted", HttpStatus.NO_CONTENT);
    }
}
