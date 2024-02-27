package edu.unc.henryRentaCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.services.ClienteReservaSAsig;


@RestController
@RequestMapping("api/v1/reservas/clir")
public class ClienteReservaCAsig {
	
	@Autowired
	private ClienteReservaSAsig cliResService;
	
	@PutMapping(value="/{idclient}/{idreserva}")
	public Reserva replaceCliente(@PathVariable Long idreserva, @PathVariable Long idclient) {
		Reserva resEntity=cliResService.replaceClient(idreserva, idclient);
		return resEntity;
	}
}
