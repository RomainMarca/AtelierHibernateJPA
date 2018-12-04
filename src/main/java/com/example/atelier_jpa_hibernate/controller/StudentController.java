package com.example.atelier_jpa_hibernate.controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.atelier_jpa_hibernate.model.School;
import com.example.atelier_jpa_hibernate.model.Student;
import com.example.atelier_jpa_hibernate.repository.SchoolRepository;
import com.example.atelier_jpa_hibernate.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SchoolRepository schoolRepository; 
	
	@GetMapping("/scholls/{schoolId}/students")
	public Page<Student> getAllStudentsBySchoolId(@PathVariable (value = "schoolId") Long schoolId,
			Pageable pageable) {
		return StudentRepository.findBySchoolId(schoolId, pageable);

	}
	

}
