package edu.unc.henryRentaCar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unc.henryRentaCar.domain.Agencia;
import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.repository.AgenciaR;
import edu.unc.henryRentaCar.repository.ReservaR;
import jakarta.transaction.Transactional;

@Service
public class ReservaAgenciaSAsigImp implements ReservaAgenciaSAsig {

	@Autowired
	private ReservaR reservaRep;
	
	@Autowired
	private AgenciaR agencyRep;
	
	@Override
	@Transactional
	public Reserva replaceAgency(Long idReserva, Long idAgency) {
		Optional<Reserva> reservaEntity=reservaRep.findById(idReserva);
		Optional<Agencia> agencyEntity=agencyRep.findById(idAgency);
		
		reservaEntity.get().setAgencia(agencyEntity.get());
		return reservaEntity.get();
	}

	@Override
	@Transactional
	public void removeAgency(Long idReserva) {
		Optional<Reserva> reservaEntity=reservaRep.findById(idReserva);
		Optional<Agencia> agencyEntity=agencyRep.findById(reservaEntity.get().getAgencia().getId_Agencia());
		
		agencyEntity.ifPresent(agency->agency.getReservas().remove(reservaEntity.get()));
		reservaEntity.get().setAgencia(null);
		
	}

}
