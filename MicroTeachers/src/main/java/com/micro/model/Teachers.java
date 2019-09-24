package com.micro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "teachers")
public class Teachers {
	
	@Id
	private String id;
	
	private String tipoIdentificacion;
	
	private String numeroIdentificacion;
	
	private String nombre;
	
    private String genero;
	
	
	
	

}
