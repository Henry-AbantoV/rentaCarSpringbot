package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import edu.unc.henryRentaCar.domain.Reserva;

public interface ReservaS {

	List<Reserva> listarReservas();
	
	Optional<Reserva>buscarReservabyId(Long IdReserva);
	
	Reserva grabarReserva (Reserva reserva);
	
	void eliminarReserva(Long IdReserva);
}
