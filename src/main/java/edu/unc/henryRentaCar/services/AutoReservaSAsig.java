package edu.unc.henryRentaCar.services;

import edu.unc.henryRentaCar.domain.Auto;

public interface AutoReservaSAsig {

	public Auto replaceReserva(Long idAuto, Long idReserva);
	public void removeReserva(Long idAuto);
}
