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


import edu.unc.henryRentaCar.domain.Cliente;
import edu.unc.henryRentaCar.services.ClienteS;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteC {

	//inyeccion de dependencias
	@Autowired
	private ClienteS clientService;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clientService.listarClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarByIdClientes(@PathVariable Long id){
		Optional<Cliente> clientOptional=clientService.buscarClientebyId(id);
		if(clientOptional.isPresent()) {
			Cliente cliente=clientOptional.get();
			if(cliente.getAvalador() !=null) {
				cliente.getAvalador().setAvalador(null);
				cliente.getAvalador().setReservas(null);
			}
			return ResponseEntity.ok(clientOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearClient(@RequestBody Cliente client){
		if(client.getAvalador() !=null && client.getAvalador().getId_Cliente()!=null) {
			Optional<Cliente> avaladorOpt=clientService.buscarClientebyId(client.getAvalador().getId_Cliente());
			
			if(avaladorOpt.isEmpty()) {
				return new ResponseEntity<>("Not aval", HttpStatus.NOT_FOUND);
			}
			client.setAvalador(avaladorOpt.get());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.grabarCliente(client));
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
	    Optional<Cliente> clienteOpt = clientService.buscarClientebyId(id);
	    if (clienteOpt.isPresent()) {
	    	
	        Cliente clienteDB = clienteOpt.get();
	        clienteDB.setDni(cliente.getDni());
	        clienteDB.setNombre(cliente.getNombre());
	        clienteDB.setDireccion(cliente.getDireccion());
	        clienteDB.setTelefono(cliente.getTelefono());

	        if (cliente.getAvalador() != null && cliente.getAvalador().getId_Cliente() != null) {
	            Optional<Cliente> avalOpt = clientService.buscarClientebyId(cliente.getAvalador().getId_Cliente());
	            if (avalOpt.isEmpty()) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avalador no encontrado");
	            }
	            clienteDB.setAvalador(avalOpt.get());
	        }
	        Cliente clienteActualizado = clientService.grabarCliente(clienteDB);
	        return ResponseEntity.ok(clienteActualizado);
	    }
	    return ResponseEntity.notFound().build();
	}

	   

	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarClient(@PathVariable Long id){
		Optional<Cliente> oClient=clientService.buscarClientebyId(id);
		if(oClient.isPresent()) {
			clientService.eliminarCliente(id);
			
			return ResponseEntity.noContent().build();
			}
		
		return ResponseEntity.notFound().build();
	}
}
