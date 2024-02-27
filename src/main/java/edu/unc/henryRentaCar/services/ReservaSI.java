package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.repository.ReservaR;

@Service
public class ReservaSI implements ReservaS {

	@Autowired
	private ReservaR reservaRep;
	
	@Override
	public List<Reserva> listarReservas() {
		return (List<Reserva>) reservaRep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Reserva> buscarReservabyId(Long IdReserva) {
		return reservaRep.findById(IdReserva);
	}

	@Override
	public Reserva grabarReserva(Reserva reserva) {
		return reservaRep.save(reserva);
	}

	@Override
	public void eliminarReserva(Long IdReserva) {
		reservaRep.deleteById(IdReserva);
		
	}

}
