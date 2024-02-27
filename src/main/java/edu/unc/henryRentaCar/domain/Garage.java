package edu.unc.henryRentaCar.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Garage {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id_Garage;
	
	private String nombre;
	private String direccion;
	
	//Relacion con auto
	@OneToMany(mappedBy="garage")
	 @JsonManagedReference
	private List<Auto> autos=new ArrayList<>();
}
