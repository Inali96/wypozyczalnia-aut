package net.codejava.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> 
{
	@Query(value = "SELECT u FROM User u WHERE userName =:userName and userPassword =:userPassword")		
	
	public User getLoginUser(@Param("userName") String userName, @Param("userPassword") String userPassword);

	@Query(value = "SELECT u FROM User u WHERE email =:email")		
	public User findUserByEmail(@Param("email") String email);	
	
}
