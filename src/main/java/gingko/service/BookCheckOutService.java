package gingko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.entity.BookCheckOut;
import gingko.repository.BookCheckOutRepository;

@Service
public class BookCheckOutService {

	@Autowired
	private BookCheckOutRepository bookCheckOutRepository;
	
	public List<BookCheckOut> findByBook(Book book) {
		return bookCheckOutRepository.findByBook(book);
	}
	
	
}
