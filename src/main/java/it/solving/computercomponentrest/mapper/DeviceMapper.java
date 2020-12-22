package it.solving.computercomponentrest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.solving.computercomponentrest.dto.DeviceDto;
import it.solving.computercomponentrest.dto.DeviceInsertDto;
import it.solving.computercomponentrest.model.Device;


@Component
public class DeviceMapper extends AbstractMapper<Device, DeviceDto> {
	
	
	@Autowired
	private ComputerMapper computerMapper;
	
	@Autowired
	private ComputerGetMapper computerGetMapper;

	@Override
	public DeviceDto convertEntityToDto(Device entity) {
		if (entity == null) {
			return null;
		}

		DeviceDto deviceDto = new DeviceDto();
		
		deviceDto.setId(entity.getId());
		deviceDto.setBrand(entity.getBrand());
		deviceDto.setCode(entity.getCode());
		deviceDto.setDescription(entity.getDescription());
		deviceDto.setComputerDto(computerMapper.convertEntityToDto(entity.getComputer()));

		return deviceDto;
	}
	
	public DeviceDto convertEntityToDto2(Device entity) {
		if (entity == null) {
			return null;
		}

		DeviceDto deviceDto = new DeviceDto();
		
		deviceDto.setId(entity.getId());
		deviceDto.setBrand(entity.getBrand());
		deviceDto.setCode(entity.getCode());
		deviceDto.setDescription(entity.getDescription());

		return deviceDto;
	}

	@Override
	public Device convertDtoToEntity(DeviceDto dto) {
		if (dto == null) {
			return null;
		}

		Device device = new Device();

		if (dto.getId() != null) {
			device.setId(dto.getId());
		}
		 
		device.setBrand(dto.getBrand());
		device.setCode(dto.getCode());
		device.setDescription(dto.getDescription());
		device.setComputer(computerMapper.convertDtoToEntity(dto.getComputerDto()));
		
		
		return device;
	}
	
	public Device convertDtoToEntity(DeviceInsertDto dto) {
		if (dto == null) {
			return null;
		}

		Device device = new Device();

		 
		device.setBrand(dto.getBrand());
		device.setCode(dto.getCode());
		device.setDescription(dto.getDescription());
		device.setComputer(computerMapper.convertDtoToEntity(dto.getComputerDto()));
		
		
		return device;
	}

}
