package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
