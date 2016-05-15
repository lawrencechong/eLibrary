package gingko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.Hold;
import gingko.entity.User;
import gingko.repository.HoldRepository;

@Service
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

	public void delete(int id) {
		Hold hold = findOne(id);
		if (userService.findCurrentUser() == hold.getUser()){
			holdRepository.delete(id);
		}
	}

	public void save(Book book, User user) {
		Hold hold = new Hold();
		hold.setBook(book);
		hold.setUser(user);
		holdRepository.save(hold);	
	}

}
