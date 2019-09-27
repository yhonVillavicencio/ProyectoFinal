package com.micro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "student")
public class Student {
  @Id
  private String codigoStudent;
  @NotEmpty(message = "Tipo de Identificacion No puede estar vacio")
  private String tipoIdentificacion;
  private String numeroIdentificacion;
  @NotEmpty(message = "Nombre No puede estar vacio")
  @Size(min = 3, max = 15)
  private String nombre;
  @NotEmpty(message = "Genero No puede estar vacio")
  private String genero;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  private Date birthdate;
  @Max(2)
  private int numeroPadres;
  
  /**
   *  constructor.
   */
  public Student(String tipoIdentificacion, String numeroIdentificacion, String nombre,
      String genero,Date birthdate,int numeroPadres) {
    this.tipoIdentificacion = tipoIdentificacion;
    this.numeroIdentificacion = numeroIdentificacion;
    this.nombre = nombre;
    this.genero = genero;
    this.birthdate = birthdate;
    this.numeroPadres = numeroPadres;
  }
}