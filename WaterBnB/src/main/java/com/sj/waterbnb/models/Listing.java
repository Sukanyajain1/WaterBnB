package com.sj.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "listings")
public class Listing {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2)
	private String listingAddress;
	
	@NotNull
	@Size(min = 2)
	private String listingDescription;
	
	@NotNull
	private String poolSize;
	
//	private Double averageRating;
	
	@NotNull
	@Min(value = 2)
	private Integer costPerNight;
	
//// ---------------------------------------------------------
//// ONE TO ONE- owner of this relationship
//// ---------------------------------------------------------
//	@OneToOne(mappedBy="listing", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private ListingAddress listingAddress;
//	
	
// ---------------------------------------------------------
// ONE TO MANY
// ---------------------------------------------------------
	@OneToMany(mappedBy="listing", fetch = FetchType.LAZY)
    private List<Review> reviews;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
	

    
    
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
	
	// ---------------------------------------------------------
	// CONSTRUCTORS
	// ---------------------------------------------------------
	public Listing () {}
	
	public Listing(Long id,
			@NotNull @Size(min = 2) String listingDescription,
			@NotNull String poolSize,
//			Double averageRating,
			@NotNull @Size(min = 2) Integer costPerNight,
			String listingAddress,
			User user,
			List<Review> reviews,
			Date createdAt,
			Date updatedAt) {
		this.id = id;
		this.listingDescription = listingDescription;
		this.poolSize = poolSize;
//		this.averageRating = averageRating;
		this.costPerNight = costPerNight;
		this.listingAddress = listingAddress;
		this.user = user;
		this.reviews = reviews;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public String getListingDescription() {
		return listingDescription;
	}
	public void setListingDescription(String listingDescription) {
		this.listingDescription = listingDescription;
	}
	public String getPoolSize() {
		return poolSize;
	}
	public void setPoolSize(String poolSize) {
		this.poolSize = poolSize;
	}
	public Integer getCostPerNight() {
		return costPerNight;
	}
	public void setCostPerNight(Integer costPerNight) {
		this.costPerNight = costPerNight;
	}
	public String getListingAddress() {
		return listingAddress;
	}
	public void setListingAddress(String listingAddress) {
		this.listingAddress = listingAddress;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setUserReviews(List<Review> reviews) {
		this.reviews = reviews;
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
	
	

    
    
}