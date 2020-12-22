package it.solving.computercomponentrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solving.computercomponentrest.dto.DeviceDto;
import it.solving.computercomponentrest.dto.DeviceInsertDto;
import it.solving.computercomponentrest.mapper.DeviceMapper;
import it.solving.computercomponentrest.model.Device;
import it.solving.computercomponentrest.repository.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private DeviceMapper deviceMapper;
	
	
	public Device save(DeviceInsertDto dto)  {
		Device device = deviceMapper.convertDtoToEntity(dto);
		try {
			return this.deviceRepository.save(device);
		} catch (Exception e) {
			throw e;
		}
	}


	public DeviceDto getById(Integer id) {
		try {
			return deviceMapper.convertEntityToDto2(deviceRepository.findById(id).get());
		}catch(Exception e){
			throw e;
		}		
	}
	
	public List<DeviceDto> getAll() {
		try {
			return deviceMapper.convertEntityToDto(deviceRepository.findAll());
		}catch(Exception e){
			throw e;
		}		
	}
	
	public Device update(DeviceDto dto)  {
		Device device = deviceMapper.convertDtoToEntity(dto);
		if(!deviceRepository.findById(device.getId()).isPresent()) {
			return null;
		}
		try {
			return this.deviceRepository.save(device);
		} catch (Exception e) {
			throw e;
		}
	}



	public boolean delete(Integer id) throws NumberFormatException {
		
		if(!deviceRepository.findById(id).isPresent()) {
			return false;
		}
		try {
			 this.deviceRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

}
