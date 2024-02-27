package edu.unc.henryRentaCar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unc.henryRentaCar.domain.Cliente;
import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.repository.ClienteR;
import edu.unc.henryRentaCar.repository.ReservaR;
import jakarta.transaction.Transactional;

@Service
public class ClienteReservaSAsigImp implements ClienteReservaSAsig {

	//inyeccion de dependencias
	
	@Autowired
	private ReservaR reservaRep;
	
	@Autowired
	private ClienteR clientRep;
	
	@Override
	@Transactional
	public Reserva replaceClient(Long idReserva, Long idClient) {
		Optional<Reserva> reservaEntity=reservaRep.findById(idReserva);
		Optional<Cliente> clientEntity=clientRep.findById(idClient);
		
		reservaEntity.get().setCliente(clientEntity.get());
		return reservaEntity.get();
	}

	@Override
	@Transactional
	public void removeClient(Long idReserva) {
		Optional<Reserva> reservaEntity=reservaRep.findById(idReserva);
		Optional<Cliente> clientEntity=clientRep.findById(reservaEntity.get().getCliente().getId_Cliente());
		
		clientEntity.ifPresent(cliente->cliente.getReservas().remove(reservaEntity.get()));
		reservaEntity.get().setCliente(null);
		
		
	}

}
