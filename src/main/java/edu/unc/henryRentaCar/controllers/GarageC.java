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

import edu.unc.henryRentaCar.domain.Garage;
import edu.unc.henryRentaCar.services.GarageS;

@RestController
@RequestMapping("api/v1/garages")
public class GarageC {


	//inyeccion de dependencias
	@Autowired
	private GarageS garService;
	
	@GetMapping
	public List<Garage> listarGarages(){
		return garService.listarGarages();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarByIdGarages(@PathVariable Long id){
		Optional<Garage> garOptional=garService.buscarGaragebyId(id);
		if(garOptional.isPresent()) {
			return ResponseEntity.ok(garOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearGarage(@RequestBody Garage garage){
		return ResponseEntity.status(HttpStatus.CREATED).body(garService.grabarGarage(garage));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editGarage(@PathVariable Long id, @RequestBody Garage garage){
		Optional<Garage> ogar=garService.buscarGaragebyId(id);
		if(ogar.isPresent()) {
			Garage gartDB=ogar.get();
			
			gartDB.setNombre(garage.getNombre());
			gartDB.setDireccion(garage.getDireccion());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(garService.grabarGarage(gartDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarGarage(@PathVariable Long id){
		Optional<Garage> ogar=garService.buscarGaragebyId(id);
		if(ogar.isPresent()) {
			garService.eliminarGarage(id);
			
			return ResponseEntity.noContent().build();
			}
		
		return ResponseEntity.notFound().build();
	}
}
