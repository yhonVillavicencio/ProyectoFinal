package com.micro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "evaluaciones")
public class Evaluaciones {
  @Id
  private String id;
  private String codigoCurso;
  private String numeroIdentificacionStudent;
  private int notaEv1;
  private int notaEv2;
  private int notaEv3;
  private int promedio;
  
  private int getPromedio() {
    return promedio = (notaEv1 + notaEv2 + notaEv3) / 3;

  }

}
