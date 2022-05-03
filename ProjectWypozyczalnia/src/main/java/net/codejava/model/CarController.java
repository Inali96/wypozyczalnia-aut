package net.codejava.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.codejava.model.CarService;

@RequestMapping("/cars")
@Controller
public class CarController 
{
	@Autowired
	private CarService carService;
	
	public Boolean checkUser(HttpSession session)
	{
		Object usersession = session.getAttribute("user2");
		User user = (User) usersession;
		System.out.println("Session "+user.getUserName());
		
		if(user==null)
			return false;
		else
			return true;
	}
	
	@RequestMapping("/reservations")
	public String GotoReservation(Map<String, Object> model) 
	{		 
		return "redirect:/reservations/"; 
	}		

	@GetMapping("/")
	public ModelAndView home(Model model, HttpSession session) 
	{
		Object usersession = session.getAttribute("user2");
	 	User user = (User) usersession;
	 	ModelAndView mav = new ModelAndView("index");	 		 	
	   // mav.addObject("welcome",welcoming());
	    
		if(user==null)
		{
			System.out.print("sesja - null");
			mav.addObject("info","Zaloguj siê ponownie");
		}					
		else
		{
			System.out.print("TASK "+user.getEmail());
			List<Car> carList = carService.listAll();
			System.out.println("LIST "+carList.size());		
			
			mav.addObject("user",user);
			mav.addObject("carList", carList);
		}	 
		
		return mav;
	}
	
	
	
	
	@RequestMapping("/new")
	public String newTaskForm(Map<String, Object> model) 
	{
		Car car = new Car(); 		 
		model.put("car", car);

		return "newCar"; 
	}	

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTask(@ModelAttribute("car") Car car, HttpSession session)
	{
		Object usersession = session.getAttribute("user2");
		User user2 = (User) usersession;
		System.out.println("Session "+user2.getUserName());
		try
		{	
			 //car.setUsers(user2);	
			 System.out.println("CAR "+car.getName());
			 carService.save(car);
				
			 //System.out.print("save: "+task.getName());
			 return "redirect:/cars/";
		}
		catch(Exception ex)
		{
			System.out.println("SAVE ERROR: " +ex.toString());
			return "redirect:/errorPage/"; 
		}
	}
	
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteTaskForm(@RequestParam Long id) 
	{
		System.out.println(id.toString());
		try
		{
			carService.deleteById(id);
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		
		return "redirect:/cars/";
	} 
	


	@RequestMapping("/edit")
	public ModelAndView editTaskForm(@RequestParam Long id, HttpSession session)
	{
		//List<Category> categories = categoryService.listAll();
		//System.out.println("categories: "+categories.size());
		ModelAndView mav = new ModelAndView("editCar");
		Car car = carService.get(id);	 		 
		mav.addObject("car", car);		

		
		return mav;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editTask(@ModelAttribute("car") Car car, HttpSession session)
	{
		Object usersession = session.getAttribute("user2");
		User user2 = (User) usersession;
		try
		{		
			//car.setUser(user2);			 
			carService.save(car);
					
			System.out.print("edit: "+car.getName()+" "+car.getId().toString());
			return "redirect:/cars/";				 
		}
		catch(Exception ex)
		{
			
			System.out.println("SAVE ERROR: " +ex.toString());
			return "redirect:/errorPage/"; 
		}
	}
	
}
