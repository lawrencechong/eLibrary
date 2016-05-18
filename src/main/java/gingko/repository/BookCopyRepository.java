package gingko.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Book;
import gingko.entity.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, Integer> {

	List<Book> findByBook(Book book);

	List<Book> findByBookAndAvailable(Book book, Boolean available);

}
