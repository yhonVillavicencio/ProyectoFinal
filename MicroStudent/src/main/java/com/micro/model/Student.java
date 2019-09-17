package com.micro.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
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
	private String fechaNacimiento;
	@Max(2)
	private int numeroPadres;
	
	public Student(@NotEmpty(message = "Tipo de Identificacion No puede estar vacio") String tipoIdentificacion,
			String numeroIdentificacion,
			@NotEmpty(message = "Nombre No puede estar vacio") @Size(min = 3, max = 30) String nombre,
			@NotEmpty(message = "Genero No puede estar vacio") String genero, String fechaNacimiento,
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
