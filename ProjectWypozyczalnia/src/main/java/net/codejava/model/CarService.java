package net.codejava.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService 
{
	@Autowired CarRepository carRepo;

	 public void save(Car task) 
	 {
		 carRepo.save(task);
	 }	
	 public List<Car> listAll() 
	 {
		 return (List<Car>) carRepo.findAll();
	 }	
	 public Car get(Long id) 
	 {
		 return carRepo.findById(id).get();
	 }	
	 public void deleteById(Long id) 
	 {
	     carRepo.deleteById(id);
	 }
	 public List<Car> getTasks(Long i) 
	 {	 
		 return (List<Car>) carRepo.getCurrentUserTask(i);
	 }	 

}
