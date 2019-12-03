package com.casino.casino.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.casino.casino.model.User;
import com.casino.casino.service.UserService;
 
@Controller
public class MainController {

    @Autowired
    private UserService service;
    
    // Injectez (inject) via application.properties.
    @Value("${welcome.message.bienvenue}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
    
    @Value("${message.inscription}")
    private String message1;
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
 
        return "connexion";
    }
    
    @RequestMapping(value = {  "/Login" }, method = RequestMethod.GET)
    public String Login(Model model) {
 
        model.addAttribute("message1", message1);
 
        return "Login";
    }
 
    @RequestMapping(value = { "/choixDeJeux" }, method = RequestMethod.GET)
    public String etudiantList(Model model) {
 
 
        return "choixDeJeux";
    }
 
    @RequestMapping(value = { "/Roulette" }, method = RequestMethod.GET)
    public String etudiantLists(Model model) {
 

 
        return "Roulette";
    }
    @RequestMapping(value = { "/connexion" }, method = RequestMethod.GET)
    public String connexion(Model model) {
 
 
        return "connexion";
    }
    @RequestMapping(value = { "/inscription" }, method = RequestMethod.GET)
    public String inscription(Model model) {
 
 
        return "inscription";
    }
    
    @RequestMapping(value = { "/machine" }, method = RequestMethod.GET)
    public String machine(Model model) {
 
 
        return "machine";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
         
        return "index";
    }

	@RequestMapping("/Inscription")
	public String showNewProductPage(Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	     
	    return "Inscription";
	}
	
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
	    service.save(user);
	     
	    return "redirect:choixDeJeux";
	}

}