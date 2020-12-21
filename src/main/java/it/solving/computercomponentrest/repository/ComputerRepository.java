package it.solving.computercomponentrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solving.computercomponentrest.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

}
