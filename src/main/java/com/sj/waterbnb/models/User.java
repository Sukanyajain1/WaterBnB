package com.sj.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="This field must be completed.")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String firstName;

    @NotEmpty(message="This field must be completed.")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String lastName;
    
    @NotEmpty(message="This field must be completed.")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="This field must be completed.")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="This field must be completed.")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
  
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
// RELATIONSHIPS
// ---------------------------------------------------------
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Listing> userListings;
    
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Review> userReviews;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "reviews",
//        joinColumns = @JoinColumn(name = "reviewer_id"),
//        inverseJoinColumns = @JoinColumn(name = "listing_id")
//    )
//    private List<Review> userReviews;
    
    
// ---------------------------------------------------------
// CONSTRUCTORS
// ---------------------------------------------------------
    public User() {}
    
	public User(Long id,
			@NotEmpty(message = "This field must be completed.") @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters") String firstName,
			@NotEmpty(message = "This field must be completed.") @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters") String lastName,
			@NotEmpty(message = "This field must be completed.") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "This field must be completed.") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
			@NotEmpty(message = "This field must be completed.") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			Date createdAt, Date updatedAt, List<Listing> userListings, List<Review> userReviews) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userListings = userListings;
		this.userReviews = userReviews;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	public List<Listing> getUserListings() {
		return userListings;
	}
	public void setUserListings(List<Listing> userListings) {
		this.userListings = userListings;
	}
	public List<Review> getUserReviews() {
		return userReviews;
	}
	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}
	

	
	

    


    
    
    
}