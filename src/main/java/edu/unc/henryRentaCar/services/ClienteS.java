package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import edu.unc.henryRentaCar.domain.Cliente;



public interface ClienteS {

	List<Cliente> listarClientes();
	
	Optional<Cliente>buscarClientebyId(Long IdCliente);
	
	Cliente grabarCliente (Cliente cliente);
	
	void eliminarCliente(Long IdCliente);
}
