package it.solving.computercomponentrest.mapper;


import org.springframework.stereotype.Component;

import it.solving.computercomponentrest.dto.ComputerDto;
import it.solving.computercomponentrest.model.Computer;

@Component
public class ComputerMapper extends AbstractMapper<Computer, ComputerDto> {

	@Override
	public ComputerDto convertEntityToDto(Computer entity) {
		if (entity == null) {
			return null;
		}

		ComputerDto computerDto = new ComputerDto();
		computerDto.setBrand(entity.getBrand());
		computerDto.setDescription(entity.getDescription());
		computerDto.setId(entity.getId());

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
		
		return computer;
	}

}
