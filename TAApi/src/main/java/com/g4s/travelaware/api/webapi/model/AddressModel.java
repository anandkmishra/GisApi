/**
 * 
 */
package com.g4s.travelaware.api.webapi.model;
import com.g4s.travelaware.api.webapi.model.ApiUserModel;
/**
 * @author GhostRider
 *
 */
public class AddressModel {
	private int id;
	
	/**
     */
    private String city;

    private ApiUserModel user;
    
    //setter
    public void setId(int id){
    	this.id = id;
    }
    
    public void setCity(String city){
    	this.city = city;
    }
   
    public void setApiUser(ApiUserModel user){
    	this.user = user;
    }
    
    
    //getter
    public int getId(){
    	return this.id;
    }
    
    public String getCity(){
    	return this.city;
    }
    
    public ApiUserModel getApiUser(){
    	return this.user;
    }
}
