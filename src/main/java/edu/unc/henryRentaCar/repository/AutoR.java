package edu.unc.henryRentaCar.repository;

import org.springframework.data.repository.CrudRepository;

import edu.unc.henryRentaCar.domain.Auto;

public interface AutoR extends CrudRepository<Auto, Long> {

}
