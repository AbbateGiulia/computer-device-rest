package it.solving.computercomponentrest.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solving.computercomponentrest.dto.ComputerDto;
import it.solving.computercomponentrest.dto.ComputerGetDto;
import it.solving.computercomponentrest.dto.ComputerInsertDto;
import it.solving.computercomponentrest.dto.DeviceDto;
import it.solving.computercomponentrest.mapper.ComputerGetMapper;
import it.solving.computercomponentrest.mapper.ComputerMapper;
import it.solving.computercomponentrest.model.Computer;
import it.solving.computercomponentrest.model.Device;
import it.solving.computercomponentrest.repository.ComputerRepository;
import it.solving.computercomponentrest.repository.DeviceRepository;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository computerRepository;

	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
	private ComputerMapper computerMapper;
	
	@Autowired
	private ComputerGetMapper computerGetMapper;

	public Computer save(ComputerInsertDto dto)  {
		Computer computer = computerMapper.convertDtoToEntity(dto);
		try {
			 this.computerRepository.save(computer);
			 for(Device device : computer.getDevices()) {
					device.setComputer(computer);				
					this.deviceRepository.save(device);					
				}
		}catch(Exception e)	{
				throw e;
			}
		return computer;

}

	public List<ComputerGetDto> getAll() {
		try {
			return computerGetMapper.convertEntityToDto(computerRepository.findAll());
		}catch(Exception e){
			throw e;
		}	
	}

	public ComputerGetDto getById(Integer id) {
		try {
			return computerGetMapper.convertEntityToDto(computerRepository.findById(id).get());
		}catch(Exception e){
			throw e;
		}	
	}

	public Computer update(ComputerDto dto)  {
		Computer computer = computerMapper.convertDtoToEntity(dto);
		if(!computerRepository.findById(computer.getId()).isPresent()) {
			return null;
		}
		try {
			 this.computerRepository.save(computer);
			 
			 for(Device device : computer.getDevices()) {
				 if(!deviceRepository.findById(device.getId()).isPresent()) {
						return null;
					}
					device.setComputer(computer);				
					this.deviceRepository.save(device);					
				}
		}catch(Exception e)	{
				throw e;
			}
		return computer;
	}
	
public boolean delete(Integer id) throws NumberFormatException {
		
		if(!computerRepository.findById(id).isPresent()) {
			return false;
		}
		try {
			 this.computerRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

}
