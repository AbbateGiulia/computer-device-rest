package it.solving.computercomponentrest.mapper;

import org.springframework.stereotype.Component;

import it.solving.computercomponentrest.dto.DeviceDto;
import it.solving.computercomponentrest.model.Device;

@Component
public class DeviceGetMapper extends AbstractMapper<Device, DeviceDto> {

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
		
		
		return device;
	}

}
