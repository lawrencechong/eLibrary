package gingko.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String firstName;
	
	private String lastName;
	
	@Column(unique = true)
//	@UniqueUsername(message = "Email already exists!")
	private String name;
	
	private String password;
	
	private boolean enabled;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy = "user")
	private List<Hold> holds;
	
	@OneToMany(mappedBy = "user")
	private List<WishList> wishlists;
	
	@OneToMany(mappedBy = "user")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy = "user")
	private List<BookCheckOut> bookcheckouts;
	
	public List<Hold> getHolds() {
		return holds;
	}

	public void setHolds(List<Hold> holds) {
		this.holds = holds;
	}

	public List<WishList> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<WishList> wishlists) {
		this.wishlists = wishlists;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<BookCheckOut> getBookcheckouts() {
		return bookcheckouts;
	}

	public void setBookcheckouts(List<BookCheckOut> bookcheckouts) {
		this.bookcheckouts = bookcheckouts;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
}
