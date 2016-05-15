package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import gingko.entity.User;
import gingko.entity.WishList;

public interface WishListRepository  extends JpaRepository<WishList, Integer>  {

	List<WishList> findByUser(User user);

}

