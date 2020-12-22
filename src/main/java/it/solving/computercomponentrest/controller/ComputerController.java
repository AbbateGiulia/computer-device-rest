package it.solving.computercomponentrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.solving.computercomponentrest.dto.ComputerDto;
import it.solving.computercomponentrest.dto.ComputerGetDto;
import it.solving.computercomponentrest.dto.ComputerInsertDto;
import it.solving.computercomponentrest.dto.ErrorDto;
import it.solving.computercomponentrest.exception.BindingResultException;
import it.solving.computercomponentrest.exception.IdException;
import it.solving.computercomponentrest.service.ComputerService;

@RestController
@RequestMapping("/api/computer")
public class ComputerController {
	
	@Autowired
	private ComputerService computerService;
	
	@GetMapping("/")
	public ResponseEntity<List<ComputerGetDto>> getAll() {

		List<ComputerGetDto> computerGetDto = computerService.getAll();

		return ResponseEntity.status(HttpStatus.OK).body(computerGetDto);
	}
	
	@PostMapping("/")
	public ResponseEntity<ComputerInsertDto> postComputer(@Valid @RequestBody ComputerInsertDto computerInsertDto,
			BindingResult bindingResult) throws Exception, BindingResultException {

		if (bindingResult.hasErrors()) {
			throw new BindingResultException(bindingResult);
		}

		computerService.save(computerInsertDto);

		return ResponseEntity.status(HttpStatus.OK).body(computerInsertDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComputerGetDto> getDevice(@PathVariable Integer id) throws Exception {

		ComputerGetDto computerGetDto = computerService.getById(id);

		return ResponseEntity.status(HttpStatus.OK).body(computerGetDto);
	}
	
	@PutMapping("/")
	public ResponseEntity<ComputerDto> putDevice(@Valid @RequestBody ComputerDto computerDto,
			BindingResult bindingResult) throws Exception, BindingResultException, IdException {
		 
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
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorDto> handleException(Exception e) {
//		List<String> errors = new ArrayList<String>();
//		errors.add(e.getMessage());
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(errors));
//	}
//	
//	@ExceptionHandler(IdException.class)
//	public ResponseEntity<ErrorDto> handleException(IdException e) {
//		List<String> errors = new ArrayList<String>();
//		errors.add(e.getError());
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(errors));
//	}
//
//	@ExceptionHandler(BindingResultException.class)
//	public ResponseEntity<ErrorDto> handleException(BindingResultException e) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//				.body(new ErrorDto(e.getBindingResult().getFieldErrors().stream()
//						.map(obj -> obj.getField() + ": " + obj.getDefaultMessage()).collect(Collectors.toList())));
//	}
//	
//	

}
