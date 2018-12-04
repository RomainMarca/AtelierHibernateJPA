package com.example.atelier_jpa_hibernate.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "langages")
public class Langage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "langages")
	private Set<Student> students = new HashSet<>();
	
	public Langage() {
	}
	
	public Langage(String name) {
		this.name = name;
	}
	
	//Getters Setters

}
