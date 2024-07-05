package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> { Student max =  new Student(
				"Max",LocalDate.of(2000, Month.FEBRUARY, 5), 
				"Max@gmail.com");
		Student sara = new Student("Sara",LocalDate.of(2000, Month.APRIL,6), 
				"Max@gmail.com");
		studentRepository.saveAll(List.of(max,sara));
		};
	};
}
