package gingko.controller;

import gingko.entity.User;
import gingko.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value="/admin")
	public String index(){
		return "admin";
	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String delete(){
//		return "deleteBook";
//	}
//	
//	@RequestMapping(value="/admin/book/ban/{id}")
//	public String ban(){
//		return "deleteBook";
//	}
//	
//	@RequestMapping(value="/admin/book/unban/{id}")
//	public String unban(){
//		return "deleteBook";
//	}
	
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String readBook(){
//		return "readBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String returnBook(){
//		return "returnBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String downloadBook(){
//		return "downloadBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String holdBook(){
//		return "deleteBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String renewBook(){
//		return "renewBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String rateBook(){
//		return "deleteBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String removeRateBook(){
//		return "deleteBook";
//	}
//	
//	@RequestMapping(value="/admin/book/delete/{id}")
//	public String addBooktoWishList(){
//		return "deleteBook";
	//}
@RequestMapping("/admin/ban/{user_name}")
public String ratings(Model model){
	User currentUser = userService.findCurrentUser();
	model.addAttribute("ban", UserService.user_name({id}));
	return "ratings";
}
	
}
