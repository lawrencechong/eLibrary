package gingko.controller;

import gingko.entity.Book;
import gingko.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search")
	public String Search(HttpServletRequest request, Model model) {
		
		String search = request.getParameter("q");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String genre = request.getParameter("genre");
		String isbn = request.getParameter("isbn");
		String view = request.getParameter("view");
		String sort = request.getParameter("sort");
		
		int page = 0;
		if (request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page").trim());
		}
		
		List<Book> books = null;
		Map<String, Object> map = new HashMap<String, Object>();
		int lastPage = 0;
		int booksFound = 0;
		
		if (search != null){
			map = searchService.search(search.trim(), page, view, sort);
			books = (List<Book>) map.get("books");
			lastPage = (Integer) map.get("lastPage");
			booksFound = (Integer) map.get("booksFound");
		} else{
			//advancedsearch
//			books = searchService.advancedSearch(title, author, genre, isbn, page, view, sort);
		} 

		model.addAttribute("books", books);
		model.addAttribute("lastPage", Integer.toString(lastPage));
		model.addAttribute("booksFound", Integer.toString(booksFound));

		int previousPage = page - 1;
		if (previousPage >= 0){
			model.addAttribute("previousPage", Integer.toString(previousPage));
		}
		int nextPage = page + 1;
		if (nextPage <= lastPage){
			model.addAttribute("nextPage", Integer.toString(nextPage));
		}
		
		model.addAttribute("page", Integer.toString(page));
		
		String currentSearch = "search?";
		
		if (search != null){
			currentSearch += "q=" + search;
		} else {
			if (title == null) title = "";
			if (author == null) author = "";
			if (genre == null) genre = "";
			if (isbn == null) isbn = "";
			
			currentSearch += "title=" + title;
			currentSearch += "&author=" + author;
			currentSearch += "&genre=" + genre;
			currentSearch += "&isbn=" + isbn;
		}
		
		if (view != null){
			currentSearch += "&view=" + view;
		}
		
		if (sort != null){
			currentSearch += "&sort=" +sort;
		}
		
		model.addAttribute("currentSearch", currentSearch);
		return "search";
	}

	@RequestMapping(value = "/adv-search")
	public String showAdvSearch() {
		return "adv-search";
	}

}
