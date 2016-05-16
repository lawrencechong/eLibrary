package gingko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gingko.service.BookService;

@Controller
public class IndexController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("books", bookService.findAll());
//		model.addAttribute("newBooks", bookService.findAll());
//		model.addAttribute("recommendedBooks", bookService.findAll());
//		model.addAttribute("ebooks", bookService.findAll());
//		model.addAttribute("audioBooks", bookService.findAll());
		return "index";
	}
	
	@RequestMapping("/help-faq")
	public String helpFAQ(){
		return "help-faq";
	}
}
