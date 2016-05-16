package gingko.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;

import gingko.entity.Book;
import gingko.entity.Rating;
import gingko.entity.User;
import gingko.repository.BookRepository;
import gingko.service.BookService;
import gingko.service.HoldService;
import gingko.service.RatingService;
import gingko.service.UserService;
import gingko.service.WishListService;

@Controller
@Transactional
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private HoldService holdService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WishListService wishListService;
	
	@Autowired
	private RatingService ratingService;
	
	@ModelAttribute("book")
	public Book construct(){
		return new Book();
	}
	
	@RequestMapping(value="/book/{id}")
	public String detail(Model model, @PathVariable int id, Principal principal) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		if (principal != null ){
			User user = userService.findCurrentUser();
			model.addAttribute("rating", ratingService.findByBookAndUser(book, user));
			model.addAttribute("book2", book);
		}
		return "book-detail";
	}
	
	@RequestMapping("/book/new")
	public String createBook(){
		return "new_book";
	}
	
	@RequestMapping(value="/book/new", method = RequestMethod.POST)
	public String doCreateBook(@ModelAttribute("book") Book book){
		bookService.save(book);
		return "redirect:/book/new?success=true";
	}

	@RequestMapping("/books/new_books")
	public String newBooks(){
		return "new_books";
	}
	
	@RequestMapping("/books/most_popular")
	public String popularBooks(){
		return "popular_books";
	}
	
	@RequestMapping("/books/type/{type}")
	public String typeBooks(){
		return "type_books";
	}
	
	@RequestMapping("/books/recommended_for_you")
	public String recommendationBooks(){
		return "recommendation_books";
	}
	
	
//	@RequestMapping(value="/books/checked_out")
//	public String checkedOut(){
//		model.addAttribute("books", bookService.findCheckedBooks());
//		return "checkedOut";
//	}
//	
//	@RequestMapping(value="/books/history")
//	public String history(){
//		return "history";
//	}
//	

//	
//	@RequestMapping(value="/books/recommended")
//	public String recommended(){
//	model.addAttribute("books", bookService.findRecommendedBooks());
//		return "recommended";
//	}
//	
//	@RequestMapping(value="/books/recommend")
//	public String recommendBook(){
//		return "recommend";
//	}
//	
//	@RequestMapping(value="/books/recommend", method = RequestMethod.POST)
//	public void doRecommendBook(@ModelAttribute("book") Book book){
////		bookService.save(book);
////		return "redirect:/book/new?success=true";
//	}
//	
//	@RequestMapping(value="/books/borrow/{id}")
//	public String borrowBook(){
//		return "borrowBook";
//	}
	
	@RequestMapping("/user/wishlist")
	public String wishlist(Model model){
		User currentUser = userService.findCurrentUser();
		model.addAttribute("wishlist", wishListService.findByUser(currentUser));
		return "wishlist";
	}
	
	@RequestMapping("/user/wishlist/delete/{id}")
	public String deleteWishListBook(@PathVariable int id) {
		wishListService.delete(id);
		return "redirect:/user/wishlist";
	}

	@RequestMapping("/user/wishlist/new/Book/{id}")
	public String newWish(@PathVariable int id) {
		Book book = bookService.findOne(id);
		User user = userService.findCurrentUser();
		wishListService.save(book,user);
		return "redirect:/user/wishlist";
	}
	
	@RequestMapping("/user/holds")
	public String holds(Model model){
		User currentUser = userService.findCurrentUser();
		model.addAttribute("holds", holdService.findByUser(currentUser));
		return "holds";
	}
	
	@RequestMapping("/user/holds/delete/{id}")
	public String deleteHold(@PathVariable int id) {
		holdService.delete(id);
		return "redirect:/user/holds";
	}
	
	@RequestMapping("/user/holds/new/Book/{id}")
	public String newHold(@PathVariable int id) {
		Book book = bookService.findOne(id);
		User user = userService.findCurrentUser();
		holdService.save(book,user);
		return "redirect:/user/holds";
	}
	
	@RequestMapping("/user/my_ratings")
	public String ratings(Model model){
		User currentUser = userService.findCurrentUser();
		model.addAttribute("ratings", ratingService.findByUser(currentUser));
		return "ratings";
	}
	
	@RequestMapping("/user/rating/{rating_id}/delete")
	public String deleteRating(@PathVariable int rating_id) {
		Rating rating = ratingService.findOne(rating_id);
		Integer book_id = rating.getBook().getId();
		ratingService.delete(rating_id);
		return "redirect:/book/" + book_id.toString();
	}
	
	@RequestMapping("/user/rate/book/{book_id}/rating/{rating_score}")
	public String editRating(@PathVariable int book_id, @PathVariable int rating_score) {
		if (rating_score >= 1 && rating_score <=5){
			Book book = bookService.findOne(book_id);
			User user = userService.findCurrentUser();
			ratingService.edit(book,user,rating_score);
		}
		return "redirect:/book/{book_id}";
	}

	
}
