package service;

import java.util.List;

import model.Student;

public interface StudentService {
	void altaStudent(Student s);
	List<Student> studentPorNotaMinima(double puntuacion);
}
