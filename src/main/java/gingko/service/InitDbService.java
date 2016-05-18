package gingko.service;

import com.google.gson.stream.JsonReader;
import gingko.entity.*;
import gingko.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		/*
		Genre genre = new Genre();
		genre.setName("Fantasy");
		genreRepository.save(genre);
		*/

		Genre genre = new Genre();
		genre.setName("");
		genreRepository.save(genre);

		try {
			JsonReader jsonReader = new JsonReader(new FileReader("src/main/java/gingko/service/book_info.json"));
			jsonReader.beginObject();
			while (jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				if (name.equals("data")) {
					jsonReader.beginArray();
					// Array
					while  (jsonReader.hasNext()) {
						jsonReader.beginObject();

						Book book = new Book();
						book.setStatus(true);

						// Element
						String title, isbn10, isbn13, publisherName, summary;
						title = isbn10 = isbn13 = publisherName = summary = "";

						ArrayList<Author> authors = new ArrayList<Author>();

						while (jsonReader.hasNext()) {
							String n = jsonReader.nextName();

							if (n.equals("isbn10")) {
								isbn10 = jsonReader.nextString();
							}
							if (n.equals("isbn13")) {
								isbn13 = jsonReader.nextString();
							}
							if (n.equals("title")) {
								title = jsonReader.nextString();
							}
							if (n.equals("authors")) {
								jsonReader.beginArray();
								while  (jsonReader.hasNext()) {
									Author a = new Author();
									a.setName(jsonReader.nextString());
									authorRepository.save(a);
									authors.add(a);
								}
								jsonReader.endArray();
							}
							if (n.equals("publisher_name")) {
								publisherName = jsonReader.nextString();
							}
							if (n.equals("summary")) {
								summary = jsonReader.nextString();
							}
						}

						book.setTitle(title);
						book.setDescription(summary);
						book.setPublisher(publisherName);
						book.setIsbn(isbn10);
						book.setAuthors(authors);
						book.setGenre(genre);

						bookRepository.save(book);

						BookCopy bookcopy = new BookCopy();
						bookcopy.setBook(book);
						bookcopy.setAvailable(true);
						bookCopyRepository.save(bookcopy);

						jsonReader.endObject();
					}
					jsonReader.endArray();
				}
			}
			jsonReader.endObject();
			jsonReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		
	}

}
