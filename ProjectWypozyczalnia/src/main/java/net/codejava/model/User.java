package net.codejava.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;	
	private String email;
	private String userPassword;
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public Set<Car> getCars() {
		return cars;
	}*/
	
	@ManyToMany(mappedBy = "users")
	private Set<Reservation> reservations = new HashSet<>(); 
	

	
	public User() {
	}

	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getEmail() 	
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return userPassword;
	}
	public void setPassword(String password) 
	{
		this.userPassword = password;
	}
	
}