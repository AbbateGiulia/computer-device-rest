package it.solving.computercomponentrest.mapper;

import org.springframework.stereotype.Component;

import it.solving.computercomponentrest.dto.ComputerGetDto;
import it.solving.computercomponentrest.model.Computer;

@Component
public class ComputerGetMapper extends AbstractMapper<Computer, ComputerGetDto> {

	@Override
	public ComputerGetDto convertEntityToDto(Computer entity) {
			if (entity == null) {
				return null;
			}

			ComputerGetDto computerGetDto = new ComputerGetDto();
			computerGetDto.setBrand(entity.getBrand());
			computerGetDto.setDescription(entity.getDescription());
			computerGetDto.setId(entity.getId());

			return computerGetDto;
		}
	

	@Override
	public Computer convertDtoToEntity(ComputerGetDto dto) {
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
