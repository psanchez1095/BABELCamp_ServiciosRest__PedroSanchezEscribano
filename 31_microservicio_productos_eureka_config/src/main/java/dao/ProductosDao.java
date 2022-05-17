package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Producto;

public interface ProductosDao extends JpaRepository<Producto,Integer>{
	@Query("select h from Hotel h where h.nombre = ?1 ")
	Producto findHotelByNombre(String nombre);
}
