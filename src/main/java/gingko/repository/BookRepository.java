package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
