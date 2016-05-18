package gingko.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Book;
import gingko.entity.BookCopy;
import gingko.entity.BookCheckOut;

public interface BookCheckOutRepository extends JpaRepository<BookCheckOut, Integer> {

	List<BookCheckOut> findByBook(Book book);

}
