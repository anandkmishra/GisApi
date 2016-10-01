/**
 * 
 */
package com.g4s.travelaware.api.webapi.model;

import io.swagger.annotations.ApiModel;


/**
 * @author GhostRider
 *
 */
//@RooJavaBean
//@RooToString
@ApiModel("ApiUser")
public class ApiUserModel {
	
	private int id;
	
	/**
     */
   
    private String fName;

    /**
     */
    private String lName;

    /**
     */
    private String subscriptionId;

    /**
     */
    private boolean isActive = false;

   /**
    * 
    */
    private AddressModel address;
    
    public void setId(int id){
    	this.id = id;
    }
    
    public void setFname(String fName){
    	this.fName = fName;
    }
    public void setLname(String lName){
    	this.lName = lName;
    }
    public void setSubscriptionId(String subscriptionId){
    	this.subscriptionId = subscriptionId;
    }
    
    public void setIsActive(boolean isActive){
    	this.isActive = isActive;
    }
    
    public void setAddress(AddressModel address){
    	this.address = address;
    }
    
    
    //getter
    public int getId(){
    	return this.id;
    }
    
    public String getFname(){
    	return this.fName;
    }
    public String getLname(){
    	return this.lName;
    }
    public String getSubscriptionId(){
    	return this.subscriptionId;
    }
    
    public boolean getIsActive(){
    	return this.isActive;
    }
    
    public AddressModel getAddress(){
    	return this.address;
    }
}
