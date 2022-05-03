package net.codejava.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import javax.persistence.JoinColumn;

@Entity
@Table(name = "Auto")
public class Car implements Serializable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String model;
	private String nr_rej;

	@OneToMany(mappedBy = "car", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	public Set<Reservation> getReservations()
	{
		return reservations;
	}	
	public void setReservations(Set<Reservation> reservations)
	{
		 this.reservations=reservations;
	}

	public Car()
	{}
	
	public Car(String name, String model,String nr_rej)
	{
		this.name = name;
		this.model = model;
		this.nr_rej = nr_rej;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNr_rej() {
		return nr_rej;
	}
	public void setNr_rej(String nr_rej) {
		this.nr_rej = nr_rej;
	}  
	
}
