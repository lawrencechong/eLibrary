package gingko.service;

import java.util.ArrayList;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.repository.BookRepository;

@Service
//@Transactional 
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> findAll(){
		return bookRepository.findAll(); 
	}

}
