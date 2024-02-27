package edu.unc.henryRentaCar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unc.henryRentaCar.domain.Auto;
import edu.unc.henryRentaCar.domain.Garage;
import edu.unc.henryRentaCar.repository.AutoR;
import edu.unc.henryRentaCar.repository.GarageR;
import jakarta.transaction.Transactional;

@Service
public class AutoGarageSAsigImp implements AutoGarageSAsig{

	@Autowired
	private AutoR autoRep;
	
	@Autowired
	private GarageR garageRep;
	
	@Override
	@Transactional
	public Auto replaceGarage(Long idAuto, Long idGarage) {
		Optional<Auto> autoEntity=autoRep.findById(idAuto);
		Optional<Garage> garEntity=garageRep.findById(idGarage);
		
		autoEntity.get().setGarage(garEntity.get());
		return autoEntity.get();
	}

	@Override
	@Transactional
	public void removeGarage(Long idAuto) {
		Optional<Auto> autoEntity=autoRep.findById(idAuto);
		Optional<Garage> garEntity=garageRep.findById(autoEntity.get().getGarage().getId_Garage());
		
		garEntity.ifPresent(garage->garage.getAutos().remove(autoEntity.get()));
		autoEntity.get().setGarage(null);
		
	}

}
