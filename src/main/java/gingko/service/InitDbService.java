package gingko.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gingko.entity.Author;
import gingko.entity.Book;
import gingko.entity.Genre;
import gingko.entity.Role;
import gingko.entity.User;
import gingko.repository.AuthorRepository;
import gingko.repository.BookRepository;
import gingko.repository.GenreRepository;
import gingko.repository.RoleRepository;
import gingko.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private GenreRepository genreRepository;

	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setName("admin");

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));

		List<Role> rolesAdmin = new ArrayList<Role>();
		rolesAdmin.add(roleUser);
		rolesAdmin.add(roleAdmin);
		userAdmin.setRoles(rolesAdmin);
		userAdmin.setFirstName("adminFirstName");
		userAdmin.setLastName("adminLastName");
		userAdmin.setEnabled(true);
		userRepository.save(userAdmin);

		User userUser = new User();
		userUser.setName("user@test.com");
		userUser.setPassword("user");
		List<Role> rolesUser = new ArrayList<Role>();
		rolesUser.add(roleUser);
		userUser.setRoles(rolesUser);
		userUser.setFirstName("userFirstName");
		userUser.setLastName("UserLastName");
		userUser.setEnabled(true);
		userRepository.save(userUser);
		
		Author author = new Author();
		author.setName("J.K. Rowling");
		authorRepository.save(author);
		
		Genre genre = new Genre();
		genre.setName("Fantasy");
		genreRepository.save(genre);
		
		Book book = new Book();
		book.setStatus(true);
		book.setTitle("Harry Potter and the Sorcerer's Stone");
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);
		book.setAuthors(authors);
		book.setDescription("Harry Potter has no idea how famous he is. That's because he's being raised by his miserable aunt and uncle who are terrified Harry will learn that he's really a wizard, just as his parents were. But everything changes when Harry is summoned to attend an infamous school for wizards, and he begins to discover some clues about his illustrious birthright. From the surprising way he is greeted by a lovable giant, to the unique curriculum and colorful faculty at his unusual school, Harry finds himself drawn deep inside a mystical world he never knew existed and closer to his own noble destiny.");
		book.setIsbn("0439708184");
		book.setGenre(genre);
//		book.setImg(img);
		bookRepository.save(book);
		
		
	}

}
