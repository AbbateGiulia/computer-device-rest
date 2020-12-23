package it.solving.computercomponentrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.solving.computercomponentrest.dto.ComputerDto;
import it.solving.computercomponentrest.dto.ComputerInsertDto;
import it.solving.computercomponentrest.exception.BindingResultException;
import it.solving.computercomponentrest.exception.IdException;
import it.solving.computercomponentrest.service.ComputerService;

@RestController
@RequestMapping("/api/computer")
public class ComputerController {
	
	@Autowired
	private ComputerService computerService;
	
	@GetMapping("/")
	public ResponseEntity<List<ComputerDto>> getAll() {

		List<ComputerDto> computerDto = computerService.getAll();

		return ResponseEntity.status(HttpStatus.OK).body(computerDto);
	}
	
	@PostMapping("/")
	public ResponseEntity<ComputerInsertDto> postComputer(@Valid @RequestBody ComputerInsertDto computerInsertDto,
			BindingResult bindingResult) throws Exception{

		if (bindingResult.hasErrors()) {
			throw new BindingResultException(bindingResult);
		}

		computerService.save(computerInsertDto);

		return ResponseEntity.status(HttpStatus.OK).body(computerInsertDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComputerDto> getDevice(@PathVariable Integer id) {

		ComputerDto computerDto = computerService.getById(id);

		return ResponseEntity.status(HttpStatus.OK).body(computerDto);
	}
	
	@PutMapping("/")
	public ResponseEntity<ComputerDto> putDevice(@Valid @RequestBody ComputerDto computerDto,
			BindingResult bindingResult) throws Exception {
		 
		if(computerService.update(computerDto)==null) {
			throw new IdException("Id inesistente");
		}
		if (bindingResult.hasErrors()) {
			
			throw new BindingResultException(bindingResult);
		}

		

		return ResponseEntity.status(HttpStatus.OK).body(computerDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ComputerDto> deleteDevice(@PathVariable Integer id) throws Exception {

		if(computerService.delete(id)==false) {
			throw new IdException("Id inesistente");
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	


}
