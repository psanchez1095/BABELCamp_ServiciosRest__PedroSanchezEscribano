package service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import model.Alumno;

//Instancia una clase mediante Spring
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	AlumnosDao alumnosDao;
	
	//Poniendo service Autowired sobraria
	public AlumnosServiceImpl(@Autowired AlumnosDao alumnosDao) {
		super();
		this.alumnosDao = alumnosDao;
	}

	@Override
	public void altaAlumno(Alumno a) {
		alumnosDao.save(a);
		
	}

	@Override
	public Alumno buscarAlumno(int idAlumno) {
		return alumnosDao.findById(idAlumno).orElse(null);
	}

	@Override
	public boolean eliminarAlumno(int idAlumno) {
		if(buscarAlumno(idAlumno)!=null) {
			alumnosDao.deleteById(idAlumno);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizarAlumno(int idAlumno,String curso) {
		Alumno aux = buscarAlumno(idAlumno);
		if(aux!=null) {
			aux.setCurso(curso);
			alumnosDao.save(aux);
			return true;
		}
		return false;
	}

	@Override
	public List<Alumno> buscarAlumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<String> buscarCursos() {
		
		return alumnosDao.findAll().stream()
		.map(aux -> aux.getCurso())
		.distinct()
		.collect(Collectors.toList());
		
	}


	

}
