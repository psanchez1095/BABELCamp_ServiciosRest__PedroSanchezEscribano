package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	RestTemplate template;
	String urlBase="http://localhost:8000/academia";
	
	public StudentServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void altaStudent(Student s) {
		template.postForLocation(urlBase+"/Alumno", s);
		
	}

	@Override
	public List<Student> studentPorNotaMinima(double puntuacion) {
		Student[] students = template.getForObject(urlBase+"/Alumnos", Student[].class);
		return Arrays
		.stream(students)
		.filter(x -> x.getPuntuacion() >= puntuacion)
		.collect(Collectors.toList());
	}

}
