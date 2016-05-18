package gingko.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"book_id", "user_id"})})
public class Hold {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private Date date_created;
	
	private Date bookAvailableDate;
	
	private String email;
	
	private Boolean autoCheckOut = true;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAutoCheckOut() {
		return autoCheckOut;
	}

	public void setAutoCheckOut(Boolean autoCheckOut) {
		this.autoCheckOut = autoCheckOut;
	}

	public Date getBookAvailableDate() {
		return bookAvailableDate;
	}

	public void setBookAvailableDate(Date bookAvailableDate) {
		this.bookAvailableDate = bookAvailableDate;
	}
	
	
}
