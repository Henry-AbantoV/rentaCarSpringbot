package edu.unc.henryRentaCar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.unc.henryRentaCar.domain.Auto;
import edu.unc.henryRentaCar.repository.AutoR;

@Service
public class AutoSI implements AutoS{

	//inyeccion de dependencias de spring
	@Autowired
	private AutoR autoRep;
	
	@Override
	public List<Auto> listarAutos() {
		return (List<Auto>) autoRep.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Auto> buscarAutobyId(Long IdAuto) {
		return autoRep.findById(IdAuto);
	}

	@Override
	public Auto grabarAuto(Auto auto) {
		return autoRep.save(auto);
	}

	@Override
	public void eliminarAuto(Long IdAuto) {
		autoRep.deleteById(IdAuto);
	}

}
