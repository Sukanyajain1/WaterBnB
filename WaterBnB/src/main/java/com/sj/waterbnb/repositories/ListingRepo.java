package com.sj.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sj.waterbnb.models.Listing;

@Repository
public interface ListingRepo extends CrudRepository <Listing, Long>{

//	LISTING OUT THE CHECKLIST OF METHODS WE HAVE AVAILABLE TO USE IN OUR APPLICATION IN THE CONTEXT OF THE LISTINGS MODEL
	
	
//	this method retrieves all the listings from the database
	List<Listing> findAll();

//  this method deletes the listing by id
	void deleteById(Long id);
}

