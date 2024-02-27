package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import edu.unc.henryRentaCar.domain.Auto;

public interface AutoS {
	
	List<Auto> listarAutos();
	
	Optional<Auto>buscarAutobyId(Long IdAuto);
	
	Auto grabarAuto (Auto auto);
	
	void eliminarAuto(Long IdAuto);

}
