package edu.unc.henryRentaCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.henryRentaCar.domain.Auto;

import edu.unc.henryRentaCar.services.AutoGarageSAsig;


@RestController
@RequestMapping("api/v1/garages/auGar")
public class AutoGarageCAsig {

	@Autowired
	private AutoGarageSAsig autGarService;
	
	@PutMapping(value="/{idauto}/{idGar}")
	public Auto replaceGarage(@PathVariable Long idauto, @PathVariable Long idGar) {
		Auto garEntity=autGarService.replaceGarage(idauto, idGar);
		return garEntity;
	}

}
