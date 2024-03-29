package edu.unc.henryRentaCar.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_Agencia")

public class Agencia {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id_Agencia;
	
	@Column(unique=true)
	private String nombre;
	private String direccion;
	private String phone;
	
	//Relacion con reserva
	@OneToMany ( mappedBy="agencia")
	private List<Reserva> reservas=new ArrayList<>();
}
