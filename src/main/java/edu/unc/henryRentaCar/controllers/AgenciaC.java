package edu.unc.henryRentaCar.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.henryRentaCar.domain.Agencia;
import edu.unc.henryRentaCar.services.AgenciaS;

@RestController
@RequestMapping("api/v1/agencias")

public class AgenciaC {
	
	//inyeccion de dependencias
	@Autowired
	private AgenciaS agencyService;
	
	@GetMapping
	public List<Agencia> listarAgencias(){
		return agencyService.listarAgencias();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarByIdAgencias(@PathVariable Long id){
		Optional<Agencia> agencyOptional=agencyService.buscarAgenciabyId(id);
		if(agencyOptional.isPresent()) {
			return ResponseEntity.ok(agencyOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearAgencia(@RequestBody Agencia agency){
		return ResponseEntity.status(HttpStatus.CREATED).body(agencyService.grabarAgencia(agency));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editAgency(@PathVariable Long id, @RequestBody Agencia agency){
		Optional<Agencia> oAgency=agencyService.buscarAgenciabyId(id);
		if(oAgency.isPresent()) {
			Agencia agencyDB=oAgency.get();
			agencyDB.setNombre(agency.getNombre());
			agencyDB.setDireccion(agency.getDireccion());
			agencyDB.setPhone(agency.getPhone());
			return ResponseEntity.status(HttpStatus.CREATED).body(agencyService.grabarAgencia(agencyDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarAgency(@PathVariable Long id){
		Optional<Agencia> oAgency=agencyService.buscarAgenciabyId(id);
		if(oAgency.isPresent()) {
			agencyService.eliminarAgencia(id);
			
			return ResponseEntity.noContent().build();
			}
		
		return ResponseEntity.notFound().build();
	}
}
