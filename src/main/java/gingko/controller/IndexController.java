package gingko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gingko.entity.User;
import gingko.service.BookService;
import gingko.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("books", bookService.findAll());
		return "index";
	}
	
	@RequestMapping("/help-faq")
	public String helpFAQ(){
		return "help-faq";
	}
}
