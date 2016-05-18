package gingko.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.User;
import gingko.entity.WishList;
import gingko.repository.WishListRepository;

@Service
@Transactional
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
	
	public  void delete(WishList wishbook) {
		if (userService.findCurrentUser() == wishbook.getUser()){
			wishListRepository.delete(wishbook.getId());
		}
	}

	public void save(Book book, User user) {
		WishList wish = new WishList();
		wish.setBook(book);
		wish.setUser(user);
		wishListRepository.save(wish);	
	}

	public WishList findByBookAndUser(Book book, User user) {
		return wishListRepository.findByBookAndUser(book,user);
	}
	
	public List<WishList> findAvailableWishListBooks(User user){
		List<WishList> availableBooks = new ArrayList<WishList>();
		List<WishList> allBooks = findByUser(user);
		for(WishList wishBook : allBooks){
			if (wishBook.getBook().isAvailable()){
				availableBooks.add(wishBook);
			}
		}
		return availableBooks;
	}
	
}
