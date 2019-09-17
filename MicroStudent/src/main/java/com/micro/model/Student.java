package com.micro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="student")
public class Student {
	
	@Id
	private String codigoStudent;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombre;
	private String genero;
	
	public Student(String tipoIdentificacion, String numeroIdentificacion, String nombre) {	
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
