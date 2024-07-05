package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
  
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public void newStudent(Student student) {
		Optional<Student> studentOptional = 
				studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}
	
	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if(exists) {
			studentRepository.deleteById(studentId);
		}else {
			throw new IllegalStateException("Invalid Id");
		}
	}
	
	@Transactional
	public void updateStudent(Long studentId,String studentName, String studentEmail) {
		Student student = 
				studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Invalid id"));
		if(studentName != null && studentName.length() > 0 && !Objects.equals(studentName, student.getName())) {
			student.setName(studentName);
		}
		
		if(studentEmail!=null && studentEmail.length() > 0 && !Objects.equals(studentEmail, student.getEmail())) {
			student.setEmail(studentEmail);
		}
	}
	
}
