package edu.unc.henryRentaCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.services.ReservaAgenciaSAsig;


@RestController
@RequestMapping("api/v1/agencias/ResAg")
public class ReservaAgenciaCAsig {

	@Autowired
	private ReservaAgenciaSAsig resAgService;
	
	@PutMapping(value="/{idReserva}/{idAgencia}")
	public Reserva replaceAgencia(@PathVariable Long idReserva, @PathVariable Long idAgencia) {
		Reserva resEntity=resAgService.replaceAgency(idReserva, idAgencia);
		return resEntity;
	}

}
