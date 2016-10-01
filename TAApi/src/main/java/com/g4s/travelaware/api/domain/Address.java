package com.g4s.travelaware.api.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 */

/**
 * @author GhostRider
 *
 */
//@RooJavaBean
//@RooJpaEntity(table = "address", schema = "dbo", identifierColumn = "id", identifierField = "addressId", identifierType = Integer.class, versionField = "")
//@RooToString(excludeFields = { "user" })
@Entity
@Table(name="Address")
public class Address {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
     */
    @NotNull
    @Column(name = "City")
    @Size(min = 8, max = 100)
    private String city;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private ApiUser user;
    
    //setter
    public void setId(int id){
    	this.id = id;
    }
    
    public void setCity(String city){
    	this.city = city;
    }
   
    public void setApiUser(ApiUser user){
    	this.user = user;
    }
    
    
    //getter
    public int getId(){
    	return this.id;
    }
    
    public String getCity(){
    	return this.city;
    }
    
    public ApiUser getApiUser(){
    	return this.user;
    }
}
