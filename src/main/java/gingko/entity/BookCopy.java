package gingko.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookCopy{

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@OneToMany(mappedBy = "bookCopy")
	private List<BookCheckOut> bookcheckouts;
	
	private Boolean available = true;

	public List<BookCheckOut> getBookcheckouts() {
		return bookcheckouts;
	}

	public void setBookcheckouts(List<BookCheckOut> bookcheckouts) {
		this.bookcheckouts = bookcheckouts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
