package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.henryRentaCar.domain.Agencia;
import edu.unc.henryRentaCar.repository.AgenciaR;

@Service
public class AgenciaSI implements AgenciaS {

	@Autowired
	private AgenciaR agencyRep;
	
	@Override
	public List<Agencia> listarAgencias() {
		return (List<Agencia>)agencyRep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Agencia> buscarAgenciabyId(Long IdAgencia) {
		return agencyRep.findById(IdAgencia);
	}

	@Override
	public Agencia grabarAgencia(Agencia agencia) {
		return agencyRep.save(agencia);
	}

	@Override
	public void eliminarAgencia(Long IdAgencia) {
		agencyRep.deleteById(IdAgencia);
		
	}

}
