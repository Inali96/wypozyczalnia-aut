package net.codejava.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController 
{
	 @Autowired
	 private UserService userService;
	 
	 @GetMapping("/")
	 public ModelAndView home(Model m) 
	 {
		  User user = new User();
		  m.addAttribute("user", user);
		  ModelAndView modelAndView = new ModelAndView("register");  
		  return modelAndView;  
	 }
	 
	 @GetMapping("/user")
	 public ModelAndView home2(Model m, HttpSession session) 
	 {
		 Object usersession = session.getAttribute("user2");
		 	User user = (User) usersession;
		 	ModelAndView mav = new ModelAndView("user");	 		 	
		   // mav.addObject("welcome",welcoming());
		 	System.out.print("TASK "+user.getEmail());
			List<User> userList = userService.listAll();
			System.out.println("LIST "+userList.size());		
			
			mav.addObject("user",user);
			mav.addObject("userList", userList);
			return mav;
	 }

	 @RequestMapping("/newUser")
		public String newTaskForm(Map<String, Object> model) 
		{
		 User user = new User(); 		 
			model.put("user", user);

			return "newUser"; 
		}	
	 @PostMapping("/newUser")
	 public String register2(@ModelAttribute ("user") User user, Model model) 
	 {
		User checkUser = userService.findByEmail(user.getEmail());
				
		if(checkUser == null)
		{	
			userService.registerUser(user);	
			model.addAttribute("Utworzono u¿ytkownika");
			return "redirect:/user/";	
		}
		else
		{	
			model.addAttribute("Email jest ju¿ zajêty");
			return "newUser";		
		}
	 }
	 @PostMapping("/register")
	 public String register(@ModelAttribute ("user") User user, Model model) 
	 {
		User checkUser = userService.findByEmail(user.getEmail());
				
		if(checkUser == null)
		{	
			user.setRole("u");
			userService.registerUser(user);	
			
		 	model.addAttribute("success","Udana rejestracja. Mo¿esz siê zalogowaæ");
		 	return "register";	
		}
		else
		{	
			model.addAttribute("error","Email jest ju¿ zajêty");
			return "register";		
		}
	 }
	 
	 @GetMapping("/login")
	 public String loginDisplay(Model m,HttpSession session) 
	 {		  
		  User user = new User();
		  
		  if (session.getAttribute("user") != null) 
		  {
		   session.invalidate();
		   session.removeAttribute("user");
		  }
		  m.addAttribute("user", user); 
		  return "login";  
	 }	
	 
	 
	 @PostMapping("/login")
	 public String login(@ModelAttribute ("user") User user, Model model, HttpSession session) 
	 {
		  User user2 = userService.loginUser(user.getUserName(),user.getPassword());
		  System.out.println("user2"+user2);

		  if(user2 != null)
		  {
			   model.addAttribute("user2",user2);
			   session.setAttribute("user2", user2);		   
			   return "redirect:/reservations/";
		  }
		  else
		  {
			  System.out.println("on");
			  model.addAttribute("error", "Niepoprawne dane. Spróbuj ponownie...");
			  return "login";	
		  }
		  
	}

}  