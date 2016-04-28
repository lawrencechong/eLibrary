package gingko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gingko.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
