package gingko.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gingko.entity.User;
import gingko.service.UserService;

import static javax.swing.text.StyleConstants.ModelAttribute;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/admin/users") 
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	} 
	
	@RequestMapping("/register")
	public String showRegister(){
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "redirect:/register?success=true";
	}
	
	@RequestMapping("/account")
	public String account(){
		return "account";
	}
	
    @RequestMapping(value = "/account/edit")
    public String userUpdate(Model model){//, Principal principal) {
    	User user = userService.findCurrentUser();
    	model.addAttribute("user", user);
        return "user-edit";
    }
    
    @RequestMapping(value="/account/edit", method = RequestMethod.POST)
	public String doUserUpdate(@ModelAttribute("user") User user, Model model){
		userService.update(user);
		model.addAttribute("user", userService.findCurrentUser());
//		return "redirect:/users";
		return "redirect:/account/edit?success=true";
	}

	@RequestMapping(value="/admin/ban/{id}", method = RequestMethod.POST)
		public String ban(Model model){
		User user = userService.findCurrentUser();
		user.setEnabled(false);

		return "admin-users";
	}

}
