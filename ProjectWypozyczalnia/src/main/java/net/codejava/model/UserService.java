package net.codejava.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class UserService 
{
	@Autowired UserRepository userRepo;
	
	public void registerUser(User user)	 
	{
		userRepo.save(user);
	}
	
	public User loginUser(String userName, String password) 
	{
		return userRepo.getLoginUser(userName,password);
	}
	
	public User findUser(User user) 
	{
		return userRepo.findUserByEmail(user.getEmail());
	}
	
	public User findByEmail(String email) 
	{
		return userRepo.findUserByEmail(email);
	}
	public List<User> listAll() 
	 {
		 return (List<User>) userRepo.findAll();
	 }
	
	
	
	
}
