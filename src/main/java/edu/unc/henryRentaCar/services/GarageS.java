package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import edu.unc.henryRentaCar.domain.Garage;

public interface GarageS {

	List<Garage> listarGarages();
	
	Optional<Garage>buscarGaragebyId(Long IdGarage);
	
	Garage grabarGarage (Garage garage);
	
	void eliminarGarage(Long IdGarage);
}
