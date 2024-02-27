package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import edu.unc.henryRentaCar.domain.Agencia;


public interface AgenciaS {

	List<Agencia> listarAgencias();
	
	//optional por si el valor es nulo
	Optional<Agencia>buscarAgenciabyId(Long IdAgencia);
	
	Agencia grabarAgencia (Agencia agencia);
	
	void eliminarAgencia(Long IdAgencia);
}
