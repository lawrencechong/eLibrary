package gingko.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gingko.entity.Author;
import gingko.entity.Book;
import gingko.entity.BookCopy;
import gingko.entity.Genre;
import gingko.entity.Hold;
import gingko.entity.Role;
import gingko.entity.User;
import gingko.repository.AuthorRepository;
import gingko.repository.BookCopyRepository;
import gingko.repository.BookRepository;
import gingko.repository.GenreRepository;
import gingko.repository.HoldRepository;
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

	@Autowired
	private HoldRepository holdRepository; 
	
	@Autowired
	private BookCopyRepository bookCopyRepository;

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
		userUser.setName("user");
		userUser.setPassword(encoder.encode("user"));
		
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

//		File file = new File("c:url value= resources/images/harry_potter.jpg"); 
//		byte [] byteFile = new byte[(int)file.length()];
//		
//		try{
//			FileInputStream fs = new FileInputStream(file);
//			fs.read(byteFile);
//			fs.close();
//		}catch (Exception e){
//			e.printStackTrace();
//		};
//		book.setImg(byteFile);
		
		bookRepository.save(book);
		
		Author author2 = new Author();
		author2.setName("George R. R. Martin");
		authorRepository.save(author2);
		
		Book book2 = new Book();
		book2.setStatus(true);
		book2.setTitle("A Game of Thrones (A Song of Ice and Fire, Book 1)");
		List<Author> authorsBook2 = new ArrayList<Author>();
		authorsBook2.add(author2);
		book2.setAuthors(authorsBook2);
		book2.setDescription("Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister and supernatural forces are massing beyond the kingdom’s protective Wall. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the land they were born to. Sweeping from a land of brutal cold to a distant summertime kingdom of epicurean plenty, here is a tale of lords and ladies, soldiers and sorcerers, assassins and bastards, who come together in a time of grim omens." +  ""
				+ "Here an enigmatic band of warriors bear swords of no human metal; a tribe of fierce wildlings carry men off into madness; a cruel young dragon prince barters his sister to win back his throne; and a determined woman undertakes the most treacherous of journeys. Amid plots and counterplots, tragedy and betrayal, victory and terror, the fate of the Starks, their allies, and their enemies hangs perilously in the balance, as each endeavors to win that deadliest of conflicts: the game of thrones." +
			"Here is the first volume in George R. R. Martin’s magnificent cycle of novels that includes A Clash of Kings and A Storm of Swords. As a whole, this series comprises a genuine masterpiece of modern fantasy, bringing together the best the genre has to offer. Magic, mystery, intrigue, romance, and adventure fill these pages and transport us to a world unlike any we have ever experienced. Already hailed as a classic, George R. R. Martin’s stunning series is destined to stand as one of the great achievements of imaginative fiction.");
		book2.setIsbn("0553386794");
		book2.setGenre(genre);
		bookRepository.save(book2);
		
		Hold hold = new Hold();
		hold.setUser(userAdmin);
		hold.setBook(book);
		holdRepository.save(hold);
		
		Hold hold2 = new Hold();
		hold2.setUser(userUser);
		hold2.setBook(book);
		holdRepository.save(hold2);
		
		BookCopy bookcopy1 = new BookCopy();
		bookcopy1.setBook(book);
		bookcopy1.setAvailable(true);
		bookCopyRepository.save(bookcopy1);
		
		BookCopy bookcopy2 = new BookCopy();
		bookcopy2.setBook(book);
		bookcopy2.setAvailable(true);
		bookCopyRepository.save(bookcopy2);
		
		BookCopy bookcopy3 = new BookCopy();
		bookcopy3.setBook(book);
		bookcopy3.setAvailable(false);
		bookCopyRepository.save(bookcopy3);
		
		BookCopy bookcopy4 = new BookCopy();
		bookcopy4.setBook(book);
		bookcopy4.setAvailable(false);
		bookCopyRepository.save(bookcopy4);
		
		BookCopy bookcopy5 = new BookCopy();
		bookcopy5.setBook(book2);
		bookcopy5.setAvailable(false);
		bookCopyRepository.save(bookcopy2);
		
	}

}
