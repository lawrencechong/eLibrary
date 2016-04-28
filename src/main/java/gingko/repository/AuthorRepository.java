package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
