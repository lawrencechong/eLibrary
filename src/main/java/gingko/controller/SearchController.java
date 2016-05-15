package gingko.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gingko.entity.Book;
import gingko.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;

	
	@RequestMapping(value = "/search")
	public String Search(@RequestParam(value = "q", required = false) String searchString, Model model) {

        model.addAttribute("books", searchService.find(searchString));
	    return "search";
	}
	
	@RequestMapping(value = "/adv-search")
	public String showAdvSearch(){
		return "adv-search";
	}
	
	@RequestMapping(value = "/adv_search")
	public String adv_search(Model model, HttpServletRequest request) {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        String isbn = request.getParameter("isbn");
        
        String searchString = request.getParameter("title");
        
        model.addAttribute("books", searchService.find(searchString));
	    return "search";
	}
	

}
