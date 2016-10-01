/**
 * 
 */
package com.g4s.travelaware.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.g4s.travelaware.api.domain.Address;

/**
 * @author GhostRider
 *
 */
//@RooJavaBean
//@RooJpaEntity(table = "ApiUser", schema = "dbo", identifierColumn = "ApiUser_id", identifierField = "id", identifierType = Integer.class, versionField = "")
//@RooToString(excludeFields = { "address" })
//@SecondaryTable(name = "Address", schema = "dbo", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ApiUser_id", referencedColumnName = "ApiUser_id"))

@Entity
@Table(name="ApiUser")
public class ApiUser {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
     */
    @NotNull
    @Column(name = "fName")
    @Size(min = 8, max = 100)
    private String fName;

    /**
     */
    @Size(min = 8, max = 100)
    @Column(name = "lName")
    private String lName;

    /**
     */
    @NotNull
    @Size(min = 8, max = 16)
    @Column(name = "subscriptionId")
    private String subscriptionId;

    /**
     */
    @Column(name = "isActive")
    private boolean isActive = false;

    @OneToOne(cascade = { CascadeType.ALL })
	@PrimaryKeyJoinColumn(name = "ApiUser_id", referencedColumnName = "ApiUser_id")
    private Address address;
    
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
    
    public void setAddress(Address address){
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
    
    public Address getAddress(){
    	return this.address;
    }
}
