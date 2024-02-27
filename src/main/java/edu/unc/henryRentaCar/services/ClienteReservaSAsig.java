package edu.unc.henryRentaCar.services;


import edu.unc.henryRentaCar.domain.Reserva;


public interface ClienteReservaSAsig {
	//ReservaCliente
	public Reserva replaceClient(Long idReserva, Long idClient);
	public void removeClient(Long idReserva);
}
