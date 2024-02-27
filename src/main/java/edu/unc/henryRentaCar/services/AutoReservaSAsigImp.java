package edu.unc.henryRentaCar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unc.henryRentaCar.domain.Auto;
import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.repository.AutoR;
import edu.unc.henryRentaCar.repository.ReservaR;
import jakarta.transaction.Transactional;

@Service
public class AutoReservaSAsigImp implements AutoReservaSAsig{

	@Autowired
	private ReservaR reservaRep;
	
	@Autowired
	private AutoR autoRep;
	
	@Override
	@Transactional
	public Auto replaceReserva(Long idAuto, Long idReserva) {
		
		Optional<Auto> autoEntity=autoRep.findById(idAuto);
		Optional<Reserva> resEntity=reservaRep.findById(idReserva);
		
		List<Reserva> reservas=new ArrayList();
		
		reservas.add(resEntity.get());
		autoEntity.get().setReservas(reservas);
		return autoEntity.get();
	}

	@Override
	public void removeReserva(Long idAuto) {
		// TODO Auto-generated method stub
		
	}
	
}
