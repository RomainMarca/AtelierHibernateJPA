package com.example.atelier_jpa_hibernate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.atelier_jpa_hibernate.model.School;
import com.example.atelier_jpa_hibernate.repository.SchoolRepository;

@RestController
public class SchoolController {
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@GetMapping("/schools")
	public List<School> getAllSchools() {
		return schoolRepository.findAll();
	}
	
	@PostMapping("/schools")
	public School createScholl(@Valid @RequestBody School school) {
		return schoolRepository.save(school);
	}
	
	@GetMapping("/schools/{id}")
	public School getSchoolById(@PathVariable(value = "id") Long schoolId) {
		return schoolRepository.findById(schoolId)
	}
	
	@PutMapping("/schools/{id}")
	public School updateSchool(@PathVariable(value = "id") Long schoolId,
			@Valid @RequestBody School schoolDetails) {
		School school = schoolRepository.findById(schoolId);
		school.setName(schoolDetails.getName());
		school.setAdress(schoolDetails.getAdress());
		
		School updatedSchool = schoolRepository.save(school);
		return updatedSchool;
	}

}
