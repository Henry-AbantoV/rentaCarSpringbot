package edu.unc.henryRentaCar.services;

import edu.unc.henryRentaCar.domain.Auto;


public interface AutoGarageSAsig {
	
	public Auto replaceGarage(Long idAuto, Long idGarage);
	public void removeGarage(Long idAuto);

}
