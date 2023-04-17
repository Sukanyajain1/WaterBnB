package com.sj.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sj.waterbnb.models.Listing;
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
		List<Listing> allListings= getAllListings();
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


		
		
		
		
		
		if (optionalListing.isPresent()) {
			return optionalListing.get();
		}else {			
			return null;
		}
	}
	
//	updates a Listing
	public Listing updateListing(Listing l) {
		return listingRepo.save(l);
	}
	
//	deletes a Listing by id
	public void deleteListingById(Long id) {
		listingRepo.deleteById(id);
	}


}