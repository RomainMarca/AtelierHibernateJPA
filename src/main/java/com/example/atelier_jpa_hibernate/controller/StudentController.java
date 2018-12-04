package com.example.atelier_jpa_hibernate.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return studentRepository.findBySchoolId(schoolId, pageable);
	}
	
	@PostMapping("/scholls/{schoolId}/students")
	public Student createStudent(@PathVariable (value= "schoolId") Long schoolId,
			@Valid @RequestBody Student student) {
		return studentRepository.findById(schoolId).map(post -> {
			student.setSchool(school);
			return studentRepository.save(student);
		})
	}
	

}
