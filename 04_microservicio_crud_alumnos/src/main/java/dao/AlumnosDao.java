package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno,Integer>{
	
	//Opt 1 : Se le da la lista de cursos ya filtrada
	@Query("select distinct(a.curso) from Alumno a")
	List<String> findCursos();
	//Opt 2: Filtrar en la capa de servicios
}
