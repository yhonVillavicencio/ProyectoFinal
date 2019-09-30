package com.micro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "courses")
public class Courses {
	
	@Id
	private String id;
	
	private String codigoCurso;
	private String nombreCurso;	
	private String numeroIdentificacionStudent;
	private String numeroIdentificacionTeacher;
	private String estadoCurso;
	private int cantidadEstudiante;
	private Evaluaciones evaluaciones;
	
	
	
	

}
