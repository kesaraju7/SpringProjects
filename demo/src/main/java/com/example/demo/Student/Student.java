package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(name="student_sequence",
	sequenceName="student_sequence",
	allocationSize=1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence")
	private Long id;
	private String name;
	private LocalDate dob;
	private String email;
	@Transient
	private Integer age;
	
	//default No-argument constructor for hibernate
    public Student() {
    }
	
	public Student(String name, LocalDate dob, String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	public Student(Long id, String name, LocalDate dob, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
