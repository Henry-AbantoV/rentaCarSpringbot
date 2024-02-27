package edu.unc.henryRentaCar.repository;

import org.springframework.data.repository.CrudRepository;

import edu.unc.henryRentaCar.domain.Garage;


public interface GarageR extends CrudRepository<Garage, Long>{

}
