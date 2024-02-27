package edu.unc.henryRentaCar.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_Cliente")
public class Cliente {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	
	private Long id_Cliente;
	
	@Column(unique=true)
	private String dni;
	
	private String nombre;
	private String direccion;
	private String telefono;
	
	//Relacion entre cliente avalador
	@ManyToOne
	@JoinColumn(name = "id_aval")
    @JsonIdentityReference(alwaysAsId = true)
	private Cliente avalador;
	
	//Relacion con reserva
	@OneToMany ( mappedBy="cliente")
	 @JsonManagedReference
	private List<Reserva> reservas=new ArrayList<>();
}
