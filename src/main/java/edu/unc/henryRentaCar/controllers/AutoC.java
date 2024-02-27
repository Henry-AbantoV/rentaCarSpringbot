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

import edu.unc.henryRentaCar.domain.Auto;
import edu.unc.henryRentaCar.services.AutoS;

@RestController
@RequestMapping("api/v1/autos")

public class AutoC {


	//inyeccion de dependencias
	@Autowired
	private AutoS autoService;
	
	@GetMapping
	public List<Auto> listarAutos(){
		return autoService.listarAutos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarByIdAutos(@PathVariable Long id){
		Optional<Auto> autoOptional=autoService.buscarAutobyId(id);
		if(autoOptional.isPresent()) {
			return ResponseEntity.ok(autoOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearAutos(@RequestBody Auto auto){
		return ResponseEntity.status(HttpStatus.CREATED).body(autoService.grabarAuto(auto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editAuto(@PathVariable Long id, @RequestBody Auto auto){
		Optional<Auto> oAuto=autoService.buscarAutobyId(id);
		if(oAuto.isPresent()) {
			Auto autoDB=oAuto.get();
			autoDB.setMatricula(auto.getMatricula());
			autoDB.setModelo(auto.getModelo());
			autoDB.setColor(auto.getColor());
			autoDB.setMarca(auto.getMarca());
			autoDB.setPrecio_reserva(auto.getPrecio_reserva());
			autoDB.setLt_gasolina(auto.getLt_gasolina());
			return ResponseEntity.status(HttpStatus.CREATED).body(autoService.grabarAuto(autoDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarAuto(@PathVariable Long id){
		Optional<Auto> oAuto=autoService.buscarAutobyId(id);
		if(oAuto.isPresent()) {
			autoService.eliminarAuto(id);
			
			return ResponseEntity.noContent().build();
			}
		
		return ResponseEntity.notFound().build();
	}
}
