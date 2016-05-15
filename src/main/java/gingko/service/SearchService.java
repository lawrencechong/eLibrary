package gingko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.repository.BookRepository;

@Service
public class SearchService {

	@Autowired
	private BookRepository bookRepository;

	
	public List<Book> find(String SearchService){
		return bookRepository.findAll(); 
	}

}
