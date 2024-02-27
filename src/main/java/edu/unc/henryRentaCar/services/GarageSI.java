package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.henryRentaCar.domain.Garage;
import edu.unc.henryRentaCar.repository.GarageR;

@Service
public class GarageSI implements GarageS {

	@Autowired
	private GarageR garageRep;
	
	@Override
	public List<Garage> listarGarages() {
		return (List<Garage>) garageRep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Garage> buscarGaragebyId(Long IdGarage) {
		return garageRep.findById(IdGarage);
	}

	@Override
	public Garage grabarGarage(Garage garage) {
		return garageRep.save(garage);
	}

	@Override
	public void eliminarGarage(Long IdGarage) {
		garageRep.deleteById(IdGarage);
	}

}
