package net.codejava.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> 
{
	@Query(value = "SELECT * FROM Task t WHERE USER_ID =:currentUser", nativeQuery = true)			
	public List<Car> getCurrentUserTask(@Param("currentUser") Long i);

}
