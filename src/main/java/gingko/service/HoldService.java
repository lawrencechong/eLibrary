package gingko.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.Hold;
import gingko.entity.User;
import gingko.repository.HoldRepository;

@Service
@Transactional
public class HoldService {
	
	@Autowired
	private HoldRepository holdRepository;
	
	@Autowired
	private UserService userService;

	public List<Hold> findByUser(User user) {
		return holdRepository.findByUser(user);
	}
	
	public Hold findOne(int id) {
		return holdRepository.findOne(id);
	}

	public void delete(Hold hold) {
		if (userService.findCurrentUser() == hold.getUser()){
			holdRepository.delete(hold.getId());
		}
	}

	public void save(Book book, User user) {
		Hold hold = new Hold();
		hold.setBook(book);
		System.out.println(user);
		System.out.println(userService.findCurrentUser());
		hold.setUser(user);
		System.out.println(hold.getUser());
		holdRepository.save(hold);	
	}

	public Hold findByBookAndUser(Book book, User user) {
		return holdRepository.findByBookAndUser(book,user);
	}

}
