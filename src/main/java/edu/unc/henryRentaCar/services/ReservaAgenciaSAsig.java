package edu.unc.henryRentaCar.services;

import edu.unc.henryRentaCar.domain.Reserva;

public interface ReservaAgenciaSAsig {

	public Reserva replaceAgency(Long idReserva, Long idAgency);
	public void removeAgency(Long idReserva);
}
