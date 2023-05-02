package com.sj.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sj.waterbnb.models.Review;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long>{

//	this method retrieves all the reviews from the database
	List<Review> findAll();

//  this method deletes the review by id
	void deleteById(Long id);
}
