package com.sj.waterbnb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sj.waterbnb.models.Review;
import com.sj.waterbnb.repositories.ReviewRepo;

@Service
public class ReviewService {
//	ADDING IN THE REPOSITORY AS A DEPENDENCY
	private final ReviewRepo reviewRepo;

	public ReviewService(ReviewRepo reviewRepo) {
		super();
		this.reviewRepo = reviewRepo;
	}
	
	public List<Review> allReviews(){
		return (List<Review>) reviewRepo.findAll();
	}

	public Review saveReview(Review r) {
		return reviewRepo.save(r);
	}

	public Review findOneReview(Long id) {
		Optional<Review> optionalReview = reviewRepo.findById(id);
			if(optionalReview.isPresent()) {
				return optionalReview.get();
			}
			else {
				return null;
			}
	}

	public void deleteReviewById(Long id) {
		reviewRepo.deleteById(id);
		
	}
	
	
	
	
	
	
	
//	public Integer reviewCount (Listing listing, User user) {
//		ArrayList<Review> allReviews = (ArrayList<Review>) reviewRepo.findAll();
//		Integer counter = 0;
//		for (Review review : allReviews) { 		      
//			if(review.getListing() == listing) {
//				counter++;
//			}
//		}
//		return counter;
//	}
	
	
	
	
	
}
