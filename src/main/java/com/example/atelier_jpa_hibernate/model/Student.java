package com.example.atelier_jpa_hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int age;
	
	//relation avec langage
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
													CascadeType.MERGE
	})
	@JoinTable(name = "student_langage",
				joinColumns = { @JoinColumn(name = "student_id")},
				inverseJoinColumns = { @JoinColumn(name = "langage_id")})
	private Set<Langage> langages = new HashSet<>();
	
	//relation avec school
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "school_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private School school;
	
	public Student() {
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	//Getters Setters
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Langage> getLangages() {
		return langages;
	}

	public void setLangages(Set<Langage> langages) {
		this.langages = langages;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	

}
