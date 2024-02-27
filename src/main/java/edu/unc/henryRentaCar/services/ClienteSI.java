package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.henryRentaCar.domain.Cliente;
import edu.unc.henryRentaCar.repository.ClienteR;

@Service
public class ClienteSI implements ClienteS{

	@Autowired
	private ClienteR clienteRep;
	
	@Override
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteRep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> buscarClientebyId(Long IdCliente) {
		return clienteRep.findById(IdCliente);
	}

	@Override
	public Cliente grabarCliente(Cliente cliente) {
		return clienteRep.save(cliente);
	}

	@Override
	public void eliminarCliente(Long IdCliente) {
		clienteRep.deleteById(IdCliente);	
	}

}
