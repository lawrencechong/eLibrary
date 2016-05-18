package gingko.service;

import java.util.ArrayList;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.User;
import gingko.repository.BookCopyRepository;
import gingko.repository.BookRepository;

@Service
//@Transactional 
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookCopyService bookCopyService;
	
	
	public List<Book> findAll(){
		return bookRepository.findAll(); 
	}


	public void save(Book book) {
		bookRepository.save(book);
		
	}
	
	public void banBook(Book book){
		book.setStatus(false);
		bookRepository.save(book);
	}
	
	public void unbanBook(Book book){
		book.setStatus(true);
		bookRepository.save(book);
	}


	public Book findOne(int id) {
		return bookRepository.findOne(id);
	}

	public int totalBookCopies(int id) {
		Book book = findOne(id);
		return bookCopyService.findByBook(book).size();
	}
	
	public int totalAvailableBookCopies(int id) {
		Book book = findOne(id);
		return bookCopyService.findByBook(book).size();
	}
}
