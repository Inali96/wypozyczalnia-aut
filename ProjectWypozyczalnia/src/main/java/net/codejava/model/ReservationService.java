package net.codejava.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService 
{
	@Autowired ReservationRepository reservationRepo;
	 
	public List<Reservation> listAll() 
	{
		return (List<Reservation>) reservationRepo.findAll();
	}
	public void save(Reservation reservation) 
	{
		reservationRepo.save(reservation);		
	}

	public Reservation get(Long id) 
	{
		return reservationRepo.findById(id).get();
	}
	 public void deleteById(Long id) 
	 {
	     
		 reservationRepo.deleteById(id);
	 }

}
