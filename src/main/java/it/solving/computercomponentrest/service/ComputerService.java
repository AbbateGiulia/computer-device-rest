package it.solving.computercomponentrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solving.computercomponentrest.repository.ComputerRepository;

@Service
public class ComputerService {
	
	@Autowired
	private ComputerRepository computerRepository;
	
	

}
