package gingko.entity;

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
	
	@ManyToMany
	@JoinTable
	private List<Author> authors;
	
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
	
}
