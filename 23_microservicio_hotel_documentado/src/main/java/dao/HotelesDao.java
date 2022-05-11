package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel,Integer>{
	@Query("select h from Hotel h where h.nombre = ?1 ")
	Hotel findHotelByNombre(String nombre);
}
