package com.UTSEM.desarrollo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	String Titulo;
	@Column
	String autor;
	@Column
	Integer anioPublicacion;
	@Column
	String ISBN;
	
}
