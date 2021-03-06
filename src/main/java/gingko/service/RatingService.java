package gingko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.Rating;
import gingko.entity.User;
import gingko.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private UserService userService;
	
	public Rating findOne(int id) {
		return ratingRepository.findOne(id);
	}
	
	public List<Rating> findByUser(User user) {
		return ratingRepository.findByUser(user);
	}
	
	public Rating findByBookAndUser(Book book, User user) {
		return ratingRepository.findByBookAndUser(book,user);
	}
	
	public void delete(int id) {
		Rating rating = findOne(id);
		if (userService.findCurrentUser() == rating.getUser()){
			ratingRepository.delete(id);
		}
	}
	
	public void edit(Book book, User user, Integer rating_score) {
		Rating rating = findByBookAndUser(book,user);
		if (rating == null){
			rating = new Rating();
			rating.setBook(book);
			rating.setUser(user);
			rating.setRating_score(rating_score);
			ratingRepository.save(rating);
		} else {
			rating.setRating_score(rating_score);
			ratingRepository.save(rating);
		}
	}

}
