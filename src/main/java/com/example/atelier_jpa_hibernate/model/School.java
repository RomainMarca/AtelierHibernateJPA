package com.example.atelier_jpa_hibernate.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String adress;
	
	//todo avoir
	
	public School() {
	}
	
	public School(String name, String adress) {
		this.name = name;
		this.adress= adress;
	}
	
	//Getters Setters

}
