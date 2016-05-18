package gingko.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Book;
import gingko.entity.Hold;
import gingko.entity.User;

public interface HoldRepository extends JpaRepository<Hold, Integer> {

	List<Hold> findByUser(User user);

	Hold findByBookAndUser(Book book, User user);

}
