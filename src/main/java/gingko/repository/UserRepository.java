package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
