package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dtos.UserPwdDto;
import model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	RestTemplate template;
	String urlBase="http://localhost:8000/academia";
	@Value("${user}")
	String user;
	@Value("${pwd}")
	String pwd;
	
	String token;
	
	public StudentServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}
	
	private void getToken() {
		var dto = new UserPwdDto(user,pwd);
		token = template.postForObject(urlBase+"/login",dto,String.class);
	}

	@Override
	public void altaStudent(Student s) {
		if(token==null || token.equals("")) {
			getToken();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		template.exchange(urlBase+"/Alumno",HttpMethod.POST,new HttpEntity<>(s,headers),Void.class);
		
	}

	@Override
	public List<Student> studentPorNotaMinima(double puntuacion) {
		if(token==null || token.equals("")) {
			getToken();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+token);
		Student[] students = template.exchange(urlBase+"/Alumnos",HttpMethod.GET,new HttpEntity<>(headers),Student[].class).getBody();
		return Arrays
		.stream(students)
		.filter(x -> x.getPuntuacion() >= puntuacion)
		.collect(Collectors.toList());
	}

}
