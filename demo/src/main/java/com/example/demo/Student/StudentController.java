package com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getStudent() {
			return studentService.getStudents();
		}
	
	@PostMapping
    public void registerNewStudent(@RequestBody Student student) {
    	studentService.newStudent(student);
    }
	
	@DeleteMapping(path ="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudentName(@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String studentName, @RequestParam(required = false) String studentEmail) {
		studentService.updateStudent(studentId,studentName,studentEmail);
	}
}
