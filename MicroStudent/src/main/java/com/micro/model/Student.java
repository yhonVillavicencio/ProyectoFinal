package com.micro.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Not;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
	@NotEmpty(message = "Tipo de Identificacion No puede estar vacio")
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	@NotEmpty(message = "Nombre No puede estar vacio")
	@Size(min=3, max=30)
	private String nombre;
	@NotEmpty(message = "Genero No puede estar vacio")
	private String genero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@Max(2)
	private int numeroPadres;
	

	
	public Student(String tipoIdentificacion2, String numeroIdentificacion2, String nombre2, String genero2,
			String string, int numeroPadres2) {
		// TODO Auto-generated constructor stub
	}


	public Student(@NotNull(message = "Tipo de Identificacion No puede estar vacio") String tipoIdentificacion,
			String numeroIdentificacion, @NotNull @Size(min = 3, max = 30) String nombre,
			@NotNull(message = "Genero No puede estar vacio") String genero, Date fechaNacimiento,
			@Max(2) int numeroPadres) {
		super();
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroPadres = numeroPadres;
	}

	

}
