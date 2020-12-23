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

import it.solving.computercomponentrest.dto.DeviceDto;
import it.solving.computercomponentrest.dto.DeviceInsertDto;
import it.solving.computercomponentrest.exception.BindingResultException;
import it.solving.computercomponentrest.exception.IdException;
import it.solving.computercomponentrest.service.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping("/")
	public ResponseEntity<List<DeviceDto>> getAll() {

		List<DeviceDto> devicesDto = deviceService.getAll();

		return ResponseEntity.status(HttpStatus.OK).body(devicesDto);
	}

	@PostMapping("/")
	public ResponseEntity<DeviceInsertDto> postDevice(@Valid @RequestBody DeviceInsertDto deviceInsertDto,
			BindingResult bindingResult) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new BindingResultException(bindingResult);
		}

		deviceService.save(deviceInsertDto);

		return ResponseEntity.status(HttpStatus.OK).body(deviceInsertDto);
	}
	
	@PutMapping("/")
	public ResponseEntity<DeviceDto> putDevice(@Valid @RequestBody DeviceDto deviceDto,
			BindingResult bindingResult) throws Exception {
		 
		if(deviceService.update(deviceDto)==null) {
			throw new IdException("Id inesistente");
		}
		if (bindingResult.hasErrors()) {
			
			throw new BindingResultException(bindingResult);
		}

		deviceService.update(deviceDto);

		return ResponseEntity.status(HttpStatus.OK).body(deviceDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeviceDto> getDevice(@PathVariable Integer id) throws Exception {

		DeviceDto deviceDto = deviceService.getById(id);

		return ResponseEntity.status(HttpStatus.OK).body(deviceDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DeviceDto> deleteDevice(@PathVariable Integer id) throws Exception {

		if(deviceService.delete(id)==false) {
			throw new IdException("Id inesistente");
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}


}
