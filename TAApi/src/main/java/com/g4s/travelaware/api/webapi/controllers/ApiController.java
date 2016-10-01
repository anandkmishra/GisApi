/**
 * 
 */
package com.g4s.travelaware.api.webapi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g4s.travelaware.api.service.AddressService;
import com.g4s.travelaware.api.service.ApiUserService;

/**
 * @author GhostRider
 *
 */
@RestController
@RequestMapping("/")
public class ApiController {
	@Autowired
	ApiUserService userService; 
	
	@Autowired
	AddressService addressService;
	
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	/**
	 * 
	 * @param clientId
	 * @param request
	 */
	protected void setUpRequest(int clientId, HttpServletRequest request) {
		//TODO: TEST the validity of the Request, Api client and User credentials	
			
	}

	/**
	 * 
	 * @param apiKey
	 * @return
	 */
	private boolean verifyKey(String apiKey) {
	
		if (apiKey == null) {
			return true;
		}
		return false;
	
		//TODO: Logic to verify the api secrete key if not a public api
		
		//TODO: logic to verify the client token to check if use is authorized before any request
	
	}
}
