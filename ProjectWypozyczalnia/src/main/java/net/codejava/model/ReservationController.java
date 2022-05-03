package net.codejava.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
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

@RequestMapping("/reservations")
@Controller
public class ReservationController
{
	@Autowired
	private UserService userService;
	@Autowired
	private CarService carService;
	@Autowired
	private ReservationService reservationService;
	
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

	
	@GetMapping("/")
	public ModelAndView home(Model model, HttpSession session) 
	{	
		ModelAndView mav = new ModelAndView("reservationIndex");	
		Object usersession = session.getAttribute("user2");
		User user = (User) usersession;	
		
			if(user.getRole().equals("a"))
			{
				mav.addObject("user",user);
				mav.addObject("reservationList", reservationService.listAll());			
				//mav.addObject("carList", reservationService.listAll());			
			}
			else if (user.getRole().equals("u"))
			{
				mav.addObject("user",user);
				mav.addObject("reservationList", getReservationListUser(user));			
			}	
			return mav;
		}
	 		 	
		
	


	private List<Reservation> getReservationListUser(User user) 
	{
		List<Reservation> reservationUser =  new ArrayList<Reservation>();	 	
		List<Reservation> allReservation = reservationService.listAll();
		
		for(int i=0; i<allReservation.size(); i++)
		{
			Reservation reservation = allReservation.get(i);		
			
			Set<User> userList = reservation.getUsers();
			ArrayList<User> list = new ArrayList<>();
			
			for (User u : userList)
			{
				list.add(u);

				if(u.getEmail().equals(user.getEmail()))
				{
					reservationUser.add(reservation);
				}
			}      		
		}
		return reservationUser;		
	}
	
	@RequestMapping("/newReservation")
	public String newEventForm(Map<String, Object> model, HttpSession session) 
	{
		List<Car> cars = carService.listAll();
		System.out.println("CARS: "+cars.size());	


		if(!checkUser(session))
			return "errorPage"; 
		
		Reservation res = new Reservation(); 		 
		model.put("reservation", res);
		model.put("cars", cars);
		//model.put("categories", categories);
		 
		return "newReservation"; 
	}	
	
	//Po przes³aniu przez formularz	CREATE
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveReservation(@ModelAttribute("reservation") Reservation reservation,HttpServletRequest request, HttpSession session)
	{
		//ModelAndView mvc = new ModelAndView("reservationIndex");
		Object usersession = session.getAttribute("user2");
		User user = (User) usersession;	
		//Reservation reservaton =  new Reservation();
		Set<User> users = new HashSet<>();
		System.out.println("PARAM");
		//System.out.println("PARAM" +request.getParameter("car"));
		
		{
			//mvc.addObject("info", "Zaloguj siê ponownie");			
		}
		if(user!=null)
		{
			
			users.add(user);			
			reservation.setUsers(users);
			//mvc = new ModelAndView("reservationIndex");
			reservationService.save(reservation);
			//mvc.addObject("info","Dodano wydarzenie ");
		}
			
		return "redirect:/reservations/";
	}	

	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteTaskForm(@RequestParam Long id,  HttpSession session) 
	{

		Object usersession = session.getAttribute("user2");
		User user = (User) usersession;
		System.out.println("Session "+user.getUserName());
		
		Reservation reservation = reservationService.get(id);
		System.out.println("Usuwanie "+reservation.getId());
		

		
		reservationService.deleteById(id);
		

		return "redirect:/reservations/";
	} 
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editReservation(@ModelAttribute("reservation") Reservation reservation, HttpServletRequest request, HttpSession session)
	{		
		Object usersession = session.getAttribute("user2");
		User user = (User) usersession;
		
		Set<User> users = new HashSet<>();
		users.add(user);
		System.out.println("EDITTT "+reservation.getId());	
			//long id = reservation.getId();
			//Reservation res = reservationService.get(id);
			//res = reservation;
			
		reservation.setUsers(users);
		reservationService.save(reservation);			
			
		return "redirect:/reservations/";	 
	}


	//FORMULARZ edit:
	@RequestMapping("/edit")
	public ModelAndView editTaskForm(@RequestParam Long id, HttpSession session)
	{
		Object usersession = session.getAttribute("user2");
		User user = (User) usersession;	
		
		Reservation reservation = reservationService.get(id);	
		List<Car> cars = carService.listAll();

		ModelAndView mav = new ModelAndView("editReservation");
		mav.addObject("reservation", reservation);
		mav.addObject("cars", cars);				
	
		return mav;
	}	
	
	@RequestMapping("/cars")
	public String backToTask(Map<String, Object> model) 
	{
		return "redirect:/cars/"; 
	}	

}
