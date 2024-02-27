package edu.unc.henryRentaCar.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_Reserva")

public class Reserva {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id_Reserva;
	
	@Temporal (TemporalType.DATE)
	private Date fechaIniicio;
	@Temporal (TemporalType.DATE)
	private Date fechaFin;
	
	private double precio_reserva;
	private String estadoAuto;
	
	// Relacion con agencia
	@ManyToOne
	private Agencia agencia;
	
	//Relacion con cliente
	@ManyToOne
	@JsonBackReference
	private Cliente cliente;
	
	//Relacion de muchos a muchos con auto

	@ManyToMany
	@JoinTable(
	  name = "Detalle_reserva", 
	  joinColumns = @JoinColumn(name = "id_Reserva"), 
	  inverseJoinColumns = @JoinColumn(name = "id_Auto"))
	private List<Auto> autos=new ArrayList<>();
	
}
