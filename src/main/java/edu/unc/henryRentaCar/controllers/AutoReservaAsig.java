package edu.unc.henryRentaCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.henryRentaCar.domain.Auto;
import edu.unc.henryRentaCar.services.AutoReservaSAsig;

@RestController
@RequestMapping("api/v1/reservas/auRes")
public class AutoReservaAsig {

	@Autowired
	private AutoReservaSAsig autResService;
	
	@PutMapping(value="/{idauto}/{idRes}")
	public Auto replaceGarage(@PathVariable Long idauto, @PathVariable Long idRes) {
		Auto autoEntity=autResService.replaceReserva(idauto, idRes);
		return autoEntity;
	}

}
