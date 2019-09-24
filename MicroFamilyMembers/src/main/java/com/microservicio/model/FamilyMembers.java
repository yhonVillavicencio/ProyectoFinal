package com.microservicio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "FamilyMembers")
public class FamilyMembers {
  @Id
  private String codigoDelFamiliar;
  @NotEmpty(message = "Tipo de Identificacion No puede estar vacio")
  private String tipoIdentificacion;
  private String numeroIdentificacion;
  @NotEmpty(message = "Nombre No puede estar vacio")
  private String nombre;
  private String codigoStudent;
  @NotEmpty(message = "Genero No puede estar vacio")
  private String genero;
  @NotEmpty(message = "Tipo del Familiar No puede estar vacio")
  private String tipoFamiliar;
  
  //Constructor
  public FamilyMembers(String tipoIdentificacion,
		String numeroIdentificacion, String nombre,
		String codigoStudent, String genero,
		String tipoFamiliar) {
	this.tipoIdentificacion = tipoIdentificacion;
	this.numeroIdentificacion = numeroIdentificacion;
	this.nombre = nombre;
	this.codigoStudent = codigoStudent;
	this.genero = genero;
	this.tipoFamiliar = tipoFamiliar;
  }
  
}
