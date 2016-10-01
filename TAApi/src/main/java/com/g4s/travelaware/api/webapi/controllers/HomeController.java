package com.g4s.travelaware.api.webapi.controllers;

import io.swagger.annotations.Api;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g4s.travelaware.api.service.AddressService;
import com.g4s.travelaware.api.service.ApiUserService;

/**
 * Handles requests for the home
 */
@RestController
@Api(value = "travelware.webapi", description = "main api", position = 1)
public class HomeController extends ApiController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, String> home() {
		Map<String,String> apiInfo = new HashMap<String, String>();
		apiInfo.put("Company", "G4S");
		apiInfo.put("Api", "TravelAware Api");
		apiInfo.put("Version", "V1.0");
		return apiInfo;
	}
	
	
	
}
