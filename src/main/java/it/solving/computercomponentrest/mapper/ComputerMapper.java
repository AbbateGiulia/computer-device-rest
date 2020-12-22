package it.solving.computercomponentrest.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.solving.computercomponentrest.dto.ComputerDto;
import it.solving.computercomponentrest.dto.ComputerGetDto;
import it.solving.computercomponentrest.dto.ComputerInsertDto;
import it.solving.computercomponentrest.model.Computer;

@Component
public class ComputerMapper extends AbstractMapper<Computer, ComputerDto> {
	
	@Autowired
	DeviceMapper deviceMapper;

	@Override
	public ComputerDto convertEntityToDto(Computer entity) {
		if (entity == null) {
			return null;
		}

		ComputerDto computerDto = new ComputerDto();
		computerDto.setBrand(entity.getBrand());
		computerDto.setDescription(entity.getDescription());
		computerDto.setId(entity.getId());
		computerDto.setDevicesDto(deviceMapper.convertEntityToDto(entity.getDevices()));

		return computerDto;
	}

	@Override
	public Computer convertDtoToEntity(ComputerDto dto) {
		if (dto == null) {
			return null;
		}

		Computer computer = new Computer();

		if (dto.getId() != null) {
			computer.setId(dto.getId());
		}

		computer.setBrand(dto.getBrand());
		computer.setDescription(dto.getDescription());
		computer.setDevices(deviceMapper.convertDtoToEntity(dto.getDevicesDto()));
		
		return computer;
	}
	
	public Computer convertDtoToEntity(ComputerInsertDto dto) {
		if (dto == null) {
			return null;
		}

		Computer computer = new Computer();

		computer.setBrand(dto.getBrand());
		computer.setDescription(dto.getDescription());
		computer.setDevices(deviceMapper.convertDtoToEntity(dto.getDevicesDto()));
		
		return computer;
	}
	
	

}
