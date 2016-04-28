package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
