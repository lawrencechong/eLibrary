package gingko.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.BookCheckOut;
import gingko.entity.BookCopy;
import gingko.repository.BookCopyRepository;

@Service
//@Transactional 
public class BookCopyService {
	
	@Autowired
	private BookCopyRepository bookCopyRepository;
	
	@Autowired 
	private BookCheckOutService bookCheckOutService;

	public BookCopy findOne(int id) {
		return bookCopyRepository.findOne(id);
	}

	public List<Book> findByBook(Book book) {
		return bookCopyRepository.findByBook(book);
	}
	
	public List<Book> findByBookAndAvailable(Book book, Boolean available){
		return bookCopyRepository.findByBookAndAvailable(book,available);
	}

	
}
