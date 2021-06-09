package com.delivary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.delivary.dto.User;
import com.delivary.repo.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showReg")
	public String showReg() {
		return "userRegister";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "UserLogin";
		
	}
	
	@RequestMapping("/registerUser")
	public String userRegister(@ModelAttribute("user") User user,ModelMap modelMap) {
		User user1=userRepo.findByEmail(user.getEmail());
		if(user1==null) {
			userRepo.save(user);
			modelMap.addAttribute("msg", "Registraion success");
			return "userRegister";
		}else {
			modelMap.addAttribute("msg", "This email is already used");
			return "userRegister";
		}
	
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
	   User user=userRepo.findByEmail(email);
	   
	   
	   if(user.getPassword().equals(password)) {
		  
		return "findStores";
	   }else {
		   modelMap.addAttribute("msg", "invalid Credentials");
		   return "UserLogin";
	   }
	   
	}
	
	@RequestMapping("/searchStores")
	public String findStores() {
		return "findStores";
	}
}
