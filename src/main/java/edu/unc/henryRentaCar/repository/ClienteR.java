package edu.unc.henryRentaCar.repository;

import org.springframework.data.repository.CrudRepository;

import edu.unc.henryRentaCar.domain.Cliente;


public interface ClienteR extends CrudRepository<Cliente, Long> {

}
