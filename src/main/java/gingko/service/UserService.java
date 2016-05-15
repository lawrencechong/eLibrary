package gingko.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	public void banUser(User user){
		user.setEnabled(false);
		userRepository.save(user);
	}
	
	public void unbanUser(User user){
		user.setEnabled(true);
		userRepository.save(user);
	}

	public User findCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return userRepository.findByName(name);
	}

	public void update(User user) {
		User currentUser = findCurrentUser();
		
		if (user.getFirstName() != null && !user.getFirstName().isEmpty())
			currentUser.setFirstName(user.getFirstName());
		
		if (user.getLastName() != null && !user.getLastName().isEmpty())
			currentUser.setLastName(user.getLastName());
		
		if (user.getName() != null && !user.getName().isEmpty())
			currentUser.setName(user.getName());
		
		if (user.getPassword() != null && !user.getPassword().isEmpty()){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			currentUser.setPassword(user.getPassword());
		}
		
		userRepository.save(currentUser);
	}
}
