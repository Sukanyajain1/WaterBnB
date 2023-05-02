package com.sj.waterbnb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sj.waterbnb.models.Listing;
import com.sj.waterbnb.models.LoginUser;
import com.sj.waterbnb.models.Review;
import com.sj.waterbnb.models.User;
import com.sj.waterbnb.services.ListingService;
import com.sj.waterbnb.services.ReviewService;
import com.sj.waterbnb.services.UserService;

@Controller
public class MainController {
	private final UserService userServ;
	private final ListingService listingServ;
	private final ReviewService reviewServ;
	
	public MainController(UserService userServ, ListingService listingServ, ReviewService reviewServ) {
		this.userServ = userServ;
		this.listingServ = listingServ;
		this.reviewServ = reviewServ;
	}
	
	
//	============================================================
//	Render Login/Register Route
//	============================================================	
	@GetMapping("/")
	public String authentication(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}

	
//	============================================================
//	Process Registration Route
//	============================================================
	@PostMapping("/register")
	public String register (@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		userServ.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		//user id put into session
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
			
	
//	============================================================
//	Process Login Route
//	============================================================
	@PostMapping("/login")
	public String login (@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		//user id put into session
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	
	
//	============================================================
//	Logout Route
//	============================================================
	@GetMapping("/logout")
	public String logout (HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
//	============================================================
//	Render Dash board Route
//	============================================================	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		session.setAttribute("listing_id", null);
		User user = userServ.findUser(userId);
		model.addAttribute("loggedUser", user);
		
		List<Listing> listings = listingServ.getAllListings();
		model.addAttribute("userId", userId);
		model.addAttribute("listings", listings);
		model.addAttribute("listing", new Listing());
		
//		AVERAGE RATINGS ON THE MEMBER DASHBOARD
//		Integer sumOfRatings;
//		for(review:listing.userReviews)
//			sumOfRatings += review.rating;
//		double avgRating = sumOfRatings/2;
		
//		HashMap of ("{listing.id}", avgRating)
		
		return "dashboard.jsp";
	}
	
	
//	============================================================
//	Create Listing Route
//	============================================================
	
	@PostMapping("/create")
	public String createListing (@Valid @ModelAttribute("listing") Listing listing, HttpSession session, BindingResult result, Model model) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			model.addAttribute("userId", userId);
			return "dashboard.jsp";
		}else {
			listingServ.saveListing(listing);
			return "redirect:/dashboard";
		}
	}
	

//  ============================================================
//  Show One Listing Route
//  ============================================================

	@GetMapping("/showListing/{id}")
	public String showListing (@PathVariable("id") Long listingId, Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		session.setAttribute("listing_id", listingId);
		User user = userServ.findUser(userId);
		Listing listing = listingServ.findOneListing(listingId);
		
		model.addAttribute("loggedUser", user);
		model.addAttribute("listing", listing);
		
		
		listingServ.updateAverageRating(listingId);
		System.out.println("This is the new average rating coming from the Main Controller Post Route: " + listing.getAverageRating());
		

		
		List <Review> allReviewsInDB = reviewServ.allReviews();
		List <Review> reviewsForOneListing = listing.getReviews();
		List <Listing> allListingsForOneUser = user.getUserListings();
		System.out.println("");
		System.out.println("Listing ID: " + listing.getId());
		System.out.println("ALL DB REVIEWS IN THE MAIN CONTROLLER:");
		
		for (Review review: allReviewsInDB) {
			System.out.println("Listing ID: " + review.getListing().getId());
			System.out.println("Review ID: " + review.getId() + ": " + review.getReviewContent());
		}
		System.out.println("");
		System.out.println("ALL LISTINGS FOR ONE USER");
		for (Listing thisListing: allListingsForOneUser) {
			System.out.println("Listing ID: " + thisListing.getId());
			System.out.println("Listing Address: " + thisListing.getListingAddress());
		}
		
		System.out.println("");
		System.out.println("ALL LISTING REVIEWS IN THE MAIN CONTROLLER:");
		for (Review eachReview: reviewsForOneListing) {
			System.out.println("Listing ID: " + eachReview.getListing().getId() + "-------" +"Review ID: " + eachReview.getId() + ": " + eachReview.getReviewContent());
		}
		
		return "viewOneListing.jsp";
	}
//	
//	there should be business logic to get an average rating from all the reviews for a single listing for display.
//	
//	
//	
//	
//	
	
//  ============================================================
//  Edit One Listing Routes
//  ============================================================

	@GetMapping("/editListing/{id}")
	public String editListing (@PathVariable("id") Long listingId, Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		
		User user = userServ.findUser(userId);
		Listing listing = listingServ.findOneListing(listingId);
		model.addAttribute("loggedUser", user);
		if(listing.getUser().getId() == userId) {
			model.addAttribute("listing", listing);
			return "editListing.jsp";
		}
		flash.addFlashAttribute("hostAlert", "You must be the host to edit this listing's information!");
		return "redirect:/dashboard";
		
	}
	
	@PutMapping("/updateListing/{id}")
	public String updateListing (@Valid @ModelAttribute("listing") Listing listing, BindingResult result) {
		System.out.println("");
		System.out.println("We're in the PUT ROUTE for update listing.");
		if(result.hasErrors()) {
			System.out.println("");
			System.out.println("THE RESULT HAS ERRORS- TRIGGERED IF STATEMENT.");
			System.out.println("ERROR: " + result.getFieldError());
			return "editListing.jsp"; 
		} else {
			System.out.println("");
			System.out.println("ELSE STATEMENT.");
			listingServ.saveListing(listing);
			System.out.println("");
			System.out.println("Just saved the listing update. redirecting to dashboard.");
			return "redirect:/dashboard";
		}
	}

	

//  ============================================================
//  Delete One Listing Route
//  ============================================================
	
	@GetMapping("/deleteListing/{id}")
	public String deleteListing(@PathVariable("id") Long listingId, Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		
		User user = userServ.findUser(userId);
		Listing listing = listingServ.findOneListing(listingId);
		model.addAttribute("loggedUser", user);
		if(listing.getUser().getId() == userId) {
			listingServ.deleteListingById(listingId);
			return "redirect:/dashboard";
		}
		flash.addFlashAttribute("driverAlert", "You must be the driver to delete this listing's information!");
		return "redirect:/dashboard";
	}
	
	
//  ============================================================
//  Create Review Route
//  ============================================================

	@GetMapping("/newReview")
	public String newReview(Model model, HttpSession session, RedirectAttributes flash) {
		System.out.println("");
		System.out.println("We're in the get route for new review.");
		Long userId = (Long) session.getAttribute("user_id");
		System.out.println("CREATED the Long userId with session user_id.");
		Long listingId = (Long) session.getAttribute("listing_id");
		
		
		User user = userServ.findUser(userId);
		Listing listing = listingServ.findOneListing(listingId);
		
		
		
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		if(listing.getUser().getId() == userId) {
			flash.addFlashAttribute("reviewerAlert", "You may only review someone else's listings!!");
			return "redirect:/showListing/" + listingId;
		}
		
		
		
		model.addAttribute("loggedUser", user);
		model.addAttribute("listing", listing);
		model.addAttribute("review", new Review());
		return "createReview.jsp";
		
	}
	
	@PostMapping("/createReview")
	public String createReview (@Valid @ModelAttribute("review") Review review, HttpSession session, BindingResult result, Model model) {
		System.out.println("");
		System.out.println("WE HAVE REACHED THE CREATE POST ROUTE");
		if (result.hasErrors()) {
			System.out.println("");
			System.out.println("THE CREATE ROUTE RESULT HAS ERRORS.");
			Long userId = (Long) session.getAttribute("user_id");
			System.out.println("CREATED the userId with the session user id.");
			model.addAttribute("userId", userId);
			return "createReview.jsp";
		}else {
			System.out.println("");
			System.out.println("we are in the else portion of the create post route.");
			System.out.println("The listing id from the newly created review: " + review.getListing().getId());
			System.out.println("The reviewer id from the newly created review: " + review.getUser().getId());
			System.out.println("The user_id: " + review.getListing().getUser().getId());
			reviewServ.saveReview(review);
			System.out.println("Just saved the new review");
			Listing currentListing = listingServ.findOneListing((Long) session.getAttribute("listing_id"));
			System.out.println("This is the current review list size after saving the review to the db: " + currentListing.getReviews().size());
//			List <Review> currentReviews = currentListing.
//			
			return "redirect:/showListing/" + currentListing.getId();
		}
	}
	
//  ============================================================
//  Update One Review Route
//  ============================================================
	@GetMapping("/editReview/{id}")
	public String editReview (@PathVariable("id") Long reviewId, Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		
		User user = userServ.findUser(userId);
		Review review = reviewServ.findOneReview(reviewId);
		model.addAttribute("loggedUser", user);
		if(review.getUser().getId() == userId) {
			model.addAttribute("review", review);
			return "editReview.jsp";
		}
		Long currentListing = review.getListing().getId();
		flash.addFlashAttribute("reviewerAlert", "You may only edit your own authored reviews!!");
		return "redirect:/showListing/" + currentListing;
		
	}
	
	@PutMapping("/updateReview/{id}")
	public String updateReview (@Valid @ModelAttribute("review") Review review, BindingResult result) {
		if(result.hasErrors()) {
			return "editReview.jsp"; 
		} else {
			Long currentListing = review.getListing().getId();
			reviewServ.saveReview(review);
			return "redirect:/showListing/" + currentListing;
		}
	}
	
//  ============================================================
//  Delete One Review Route
//  ============================================================
	@GetMapping("/deleteReview/{id}")
	public String deleteReview(@PathVariable("id") Long reviewId, Model model, HttpSession session, RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId == null) {
			flash.addFlashAttribute("logAlert", "Please login or register before entering the site!!");
			return "redirect:/";
		}
		
		User user = userServ.findUser(userId);
		Review review = reviewServ.findOneReview(reviewId);
		model.addAttribute("loggedUser", user);
		Long currentListing = review.getListing().getId();
		
		if(review.getUser().getId() == userId) {
			reviewServ.deleteReviewById(reviewId);
			return ("redirect:/showListing/" + currentListing);
		}
		flash.addFlashAttribute("reviewerAlert", "You may only delete your own authored reviews!!");
		return ("redirect:/showListing/" + currentListing);
	}
	
}
	

	

	
	
	
	
	
	
	