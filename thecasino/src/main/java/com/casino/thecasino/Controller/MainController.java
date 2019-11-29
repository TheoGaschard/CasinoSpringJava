package com.casino.thecasino.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casino.thecasino.Dao.UserDAO;
import com.casino.thecasino.Validator.UserValidator;
import com.casino.thecasino.form.UserForm;
import com.casino.thecasino.model.User;
//import com.casino.thecasino.repository.UserRepository;
import com.casino.thecasino.service.UserService;
 
@Controller
public class MainController {
 
 
	   @Autowired
	   private UserDAO userDAO;
	 
//	   @Autowired
//	   private UserRepository userRepository;
	   
	   @Autowired
	   private UserService userService;
	 
	   @Autowired
	   private UserValidator userValidator;

	   
//	    Set a form validator
	   @InitBinder
	   protected void initBinder(WebDataBinder dataBinder) {
	      // Form target
	      Object target = dataBinder.getTarget();
	      if (target == null) {
	         return;
	      }
	      System.out.println("Target=" + target);
	 
	      if (target.getClass() == UserForm.class) {
	         dataBinder.setValidator(userValidator);
	      }
	      
	   }

 
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
 
        return "index";
    }
    
    
    @RequestMapping("/registerSuccessful")
    public String viewRegisterSuccessful(Model model) {
  
       return "registerSuccessful";
    }
    
    // Show Register page.
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String viewRegister(Model model) {
  
       UserForm form = new UserForm();
  
       model.addAttribute("UserForm", form);
  
       return "Register";
    }
    
    
    @RequestMapping(value = {  "/Register" }, method = RequestMethod.POST)
    public String Register(Model model,@ModelAttribute("UserForm") @Validated UserForm userForm, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {
    	
        // Validate result

        User newUser= null;
        try {
          newUser = userDAO.createUser(userForm);
        }
        // Other error!!
        catch (Exception e) {
           return "Login";
        }
   
        redirectAttributes.addFlashAttribute("flashUser", newUser);
        model.addAttribute("message1", message1);
        return "redirect:/registerSuccessful";
     }
 
    @GetMapping (value = "/AddRegister")
    public String addUserPage(Model model) {
//    User user = userRepository.findbyPseudo(pseudo);
    	
		return "AddRegister";
    	
    }
 
    @PostMapping(value = "/AddRegister")
    public String addUser(@RequestParam("pseudo") String pseudo,
    		@RequestParam("password") String password,
    		Model model) {
    	userService.addUser(pseudo, password, 1000);
    	
    	return "redirect:/ChoixJeu";
    }
    
    
    
    @RequestMapping(value = { "/ChoixJeu" }, method = RequestMethod.GET)
    public String ChoixJeu(Model model) {
 
 
        return "ChoixJeu";
    }
 
    @RequestMapping(value = { "/Roulette" }, method = RequestMethod.GET)
    public String Roulette(Model model) {
 

 
        return "Roulette";
    }


    @RequestMapping(value = { "/Machine" }, method = RequestMethod.GET)
    public String Machine(Model model) {
 

 
        return "Machine";
    }    
    
}