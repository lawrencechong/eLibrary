package gingko.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String isbn;
	
	private String title;
	
	private Boolean licensed;
	
	private Date date_added;
	
	@ManyToMany
	@JoinTable(name="BookAuthor", 
    joinColumns=@JoinColumn(name="id"),
    inverseJoinColumns=@JoinColumn(name="author_id"))  
	private List<Author> authors;
	
	@OneToMany(mappedBy = "book")
	private List<BookCopy> bookcopies;
	
	public List<BookCopy> getBookcopies() {
		return bookcopies;
	}

	public void setBookcopies(List<BookCopy> bookcopies) {
		this.bookcopies = bookcopies;
	}

	public List<BookCheckOut> getBookcheckouts() {
		return bookcheckouts;
	}

	public void setBookcheckouts(List<BookCheckOut> bookcheckouts) {
		this.bookcheckouts = bookcheckouts;
	}

	@OneToMany(mappedBy = "book")
	private List<BookCheckOut> bookcheckouts;
	
	@OneToMany(mappedBy = "book")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy = "book")
	private List<Hold> holds;
	
	@OneToMany(mappedBy = "book")
	private List<WishList> wishlists;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@Lob
	@Column(length = 10000, name = "description")
	private String description;

	private String publisher;

	@Lob
	@Column(name="IMG")
	private byte[] img;

	private Boolean status;
	
//	private Date publishDate;

	public Integer getId() {
		return id;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Boolean getLicensed() {
		return licensed;
	}

	public void setLicensed(Boolean licensed) {
		this.licensed = licensed;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	
	public boolean isAvailable(){
		return this.getBookcopies().size() > this.getBookcheckouts().size();
	}
	
	public static List<Book> onlyAvailableBooks(List<Book> books){
		List<Book> availableBooks = new ArrayList<Book>();
		for(Book book : books){
			if (book.isAvailable()){
				availableBooks.add(book);
			}
		}
		return availableBooks;
	}
	
	public String shortenDescription(){
		if (this.getDescription().length() > 360){
			return this.getDescription().substring(0, 360).trim() + "...";
		} else {
			return this.getDescription();
		}
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
