package gingko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.Hold;
import gingko.entity.User;
import gingko.entity.WishList;
import gingko.repository.HoldRepository;
import gingko.repository.WishListRepository;

@Service
public class WishListService {
	
	@Autowired
	private WishListRepository wishListRepository;
	
	@Autowired
	private UserService userService;

	public WishList findOne(int id) {
		return wishListRepository.findOne(id);
	}
	
	public List<WishList> findByUser(User user) {
		return wishListRepository.findByUser(user);
	}
	
	public  void delete(int id) {
		WishList wish = findOne(id);
		if (userService.findCurrentUser() == wish.getUser()){
			wishListRepository.delete(id);
		}
	}

	public void save(Book book, User user) {
		WishList wish = new WishList();
		wish.setBook(book);
		wish.setUser(user);
		wishListRepository.save(wish);	
	}
	
}
