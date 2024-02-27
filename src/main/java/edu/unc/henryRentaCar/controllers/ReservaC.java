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

import edu.unc.henryRentaCar.domain.Reserva;
import edu.unc.henryRentaCar.services.ReservaS;

@RestController
@RequestMapping("api/v1/reservas")
public class ReservaC {

	//inyeccion de dependencias
	@Autowired
	private ReservaS reservaService;
	
	@GetMapping
	public List<Reserva> listarReservas(){
		return reservaService.listarReservas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarByIdReservas(@PathVariable Long id){
		Optional<Reserva> reOptional=reservaService.buscarReservabyId(id);
		if(reOptional.isPresent()) {
			return ResponseEntity.ok(reOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearGarage(@RequestBody Reserva reserva){
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.grabarReserva(reserva));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editReserva(@PathVariable Long id, @RequestBody Reserva reserva){
		Optional<Reserva> oreserva=reservaService.buscarReservabyId(id);
		if(oreserva.isPresent()) {
			Reserva resDB=oreserva.get();
			
			resDB.setFechaIniicio(reserva.getFechaIniicio());
			resDB.setFechaFin(reserva.getFechaFin());
			resDB.setPrecio_reserva(reserva.getPrecio_reserva());
			resDB.setEstadoAuto(reserva.getEstadoAuto());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.grabarReserva(resDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarReserva(@PathVariable Long id){
		Optional<Reserva> ores=reservaService.buscarReservabyId(id);
		if(ores.isPresent()) {
			reservaService.eliminarReserva(id);
			
			return ResponseEntity.noContent().build();
			}
		
		return ResponseEntity.notFound().build();
	}
}
