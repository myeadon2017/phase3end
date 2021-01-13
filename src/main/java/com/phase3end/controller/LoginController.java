package com.phase3end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.phase3end.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@GetMapping("/login")
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@PostMapping("/login")
	public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
		boolean isValidUser = service.validateUser(username, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("username", username);
		model.put("password", password);
		
		return "welcome";
	}

	@GetMapping("/register")
	//@ResponseBody
	public String register(ModelMap model) {
		return "register";


}
	@PostMapping(value = "/register")
	public String addUser(ModelMap model, @RequestParam("username")String username,@RequestParam("password")String password) {
		
		if(service.addUser(username, password)) {
			
		return "redirect:/login";
		}
		return "register";
	}

}
