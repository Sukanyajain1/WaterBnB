package com.sj.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sj.waterbnb.models.Listing;
import com.sj.waterbnb.models.Review;
import com.sj.waterbnb.repositories.ListingRepo;

@Service
public class ListingService {
//	ADDING IN THE REPOSITORY AS A DEPENDENCY
	private final ListingRepo listingRepo;
	
//	CONSTRUCTOR
	public ListingService(ListingRepo listingRepo) {
		this.listingRepo = listingRepo;
	}
	
//	returns all the Listings
	public List<Listing> getAllListings(){
		return listingRepo.findAll();
	}
	
//	creates a Listing
	public Listing saveListing(Listing l) {
		return listingRepo.save(l);
	}
	
//	retrieves a Listing
	public Listing findOneListing(Long id) {
//		Optional returns an object that may or may not contain your search result- if it contains null, you are preparing the method to handle that result and return null further into the chain.
		Optional<Listing> optionalListing = listingRepo.findById(id);
		if (optionalListing.isPresent()) {
			return optionalListing.get();
		}else {			
			return null;
		}
	}
	
	
	
//	List<Listing> allListings= getAllListings();
//		
//		SPLIT THE SEARCH STRING USING .SPLIT() ----> IT WILL TURN THE STRING INTO A LIST AT EACH WHITESPACE
	
//		************
//		someText = "welcome to the jungle"
//		x = someText.split()
//		print(x)
//		
//		RESULT: 
//		['welcome', 'to', 'the', 'jungle']
//		
//		
//		************
//		creating a loop for the search results from the home page before login/register
//		
//		for each of the attribute of listing address for each address, does the first list item match or is contained?
//		
//		Is searchEntry[0] contained in the listingAddress.displayedAddress of allListings[0]
	
//		Is searchEntry[1] contained in the listingAddress.displayedAddress of allListings[1]
	
	
	
	
	
	
	
	
//	updates a Listing
	public Listing updateListing(Listing l) {
		return listingRepo.save(l);
	}
	
//	deletes a Listing by id
	public void deleteListingById(Long id) {
		listingRepo.deleteById(id);
	}

	
	
//	update the average rating of a listing WHEN a new review is added:
//	get a list of all the reviews for one listing
//	calculate the average rating and set the value as the new average rating in the post route of create review
//	
	public Listing updateAverageRating(Long id) {
		Optional<Listing> optionalListing = listingRepo.findById(id);
		System.out.println("The update got to the Listing Service.");
		if (optionalListing.isPresent()) {
			System.out.println("optionalListing is present.");
			List <Review> currentReviews = optionalListing.get().getReviews();
			if (!currentReviews.isEmpty()) {
				System.out.println("This is the first review in the currentReviews list: " + currentReviews.get(0).getReviewContent());
				double reviewSum = 0;
				System.out.println("This is the reviewSum value before the loop: " + reviewSum);
				System.out.println("THE REVIEW CONTENT FOR EACH LOOP: ");
			
			
				for (Review review: currentReviews) {
					System.out.println("Review ID: " + review.getId() + ": " + review.getReviewContent());
					reviewSum += review.getRating();
					System.out.println("Updated reviewSum at the end of the loop: " + reviewSum);
				}
				System.out.println("reviewSum AFTER THE LOOP: " + reviewSum);
				System.out.println("SIZE OF THE REVIEWS LIST: " + currentReviews.size());
				Double averageRating = (double)  (Math.round((reviewSum/currentReviews.size())*10.0)/10.0);
				System.out.println("This is the average rating after the loop: " + averageRating);
				optionalListing.get().setAverageRating(averageRating);
				listingRepo.save(optionalListing.get());
				System.out.println("Reset the average rating value in the listing to this: " + optionalListing.get().getAverageRating());
				return optionalListing.get();
			
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	}
	
	
	
	
	
	
	
}









