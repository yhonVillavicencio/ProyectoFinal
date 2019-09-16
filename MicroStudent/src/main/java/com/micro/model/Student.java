package com.micro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student")
public class Student {
	
	@Id
	private String codigoStudent;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombre;
	
	public String getCodigoStudent() {
		return codigoStudent;
	}
	public void setCodigoStudent(String codigoStudent) {
		this.codigoStudent = codigoStudent;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Student() {
		
	}
	public Student(String tipoIdentificacion, String numeroIdentificacion, String nombre) {	
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
	}

	
	

}
