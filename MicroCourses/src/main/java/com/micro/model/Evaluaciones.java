package com.micro.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "evaluaciones")
public class Evaluaciones {
	
	
	private String codigoCurso;
	private String numeroIdentificacionStudent;
	private int notaEv1;
	private int notaEv2;
	private int notaEv3;	
	private int promedio;

     private int getPromedio() {
	   return promedio= (notaEv1+notaEv2+notaEv3)/3;
	   
	  
  }
	

}
