package net.codejava.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> 
{
	@Modifying
	@Query(value = "DELETE FROM Reservation WHERE id =:resID", nativeQuery = true)
	public void deleteSelected(@Param("resID") Long id);


	/*@Modifying
	@Query(value = "UPDATE Reservation r set r.date_start=res  FROM Reservation WHERE id =:resID", nativeQuery = true)
	public void update(@Param("res") Reservation res);*/
}
