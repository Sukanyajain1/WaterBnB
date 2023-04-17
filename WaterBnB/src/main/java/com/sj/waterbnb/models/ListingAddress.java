package com.sj.waterbnb.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="listingAddresses")
public class ListingAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String displayedAddress = houseNumber + " " + street + " " + city + " " + state + " " + zipCode;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="listingAddress_id")
    private Listing listing;
    
    
// ---------------------------------------------------------
// CONSTRUCTORS
// ---------------------------------------------------------
    public ListingAddress() {}
    
    public ListingAddress(Long id, String houseNumber, String street, String city, String state, String zipCode,
    		String displayedAddress, Date createdAt, Date updatedAt, Listing listing) {
    	this.id = id;
    	this.houseNumber = houseNumber;
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zipCode = zipCode;
    	this.displayedAddress = displayedAddress;
    	this.createdAt = createdAt;
    	this.updatedAt = updatedAt;
    	this.listing = listing;
    }

    


	// ---------------------------------------------------------
// GETTERS AND SETTERS
// ---------------------------------------------------------
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getDisplayedAddress() {
		return displayedAddress;
	}


	public void setDisplayedAddress(String displayedAddress) {
		this.displayedAddress = displayedAddress;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Listing getListing() {
		return listing;
	}


	public void setListing(Listing listing) {
		this.listing = listing;
	}


	
	
}

