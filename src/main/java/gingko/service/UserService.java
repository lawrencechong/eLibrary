package gingko.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gingko.entity.Role;
import gingko.entity.User;
import gingko.repository.RoleRepository;
import gingko.repository.UserRepository;

@Service
@Transactional 
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAll(){
		return userRepository.findAll(); 
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> rolesUser = new ArrayList<Role>();
		rolesUser.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(rolesUser);
		userRepository.save(user);
	}
}
