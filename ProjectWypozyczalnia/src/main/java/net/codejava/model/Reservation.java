package net.codejava.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String date_start;
	private String date_end;
	
	@ManyToMany( fetch = FetchType.EAGER) 
	@JoinTable(
	        name = "user_car",  
	        joinColumns = { @JoinColumn(name = "id_reservation") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_user") } 
	    )
	    Set<User> users = new HashSet<>();
	
	@ManyToOne (targetEntity = Car.class, fetch = FetchType.EAGER)	//, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_car")	 
	private Car car;	
	
	
	public Car getCar() 
	{
		return car;
	}

	public void setCar(Car car)
	{
		this.car = car;
	}
	
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	public Reservation()
	{}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<User> getUsers() 
	{
		return  users;
	}
	public void setUsers(Set<User> users) 
	{
		this.users = users;
	}  
}
