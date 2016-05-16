package gingko.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Book;
import gingko.entity.Rating;
import gingko.entity.User;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	List<Rating> findByUser(User user);

	Rating findByBookAndUser(Book book, User user);
}
