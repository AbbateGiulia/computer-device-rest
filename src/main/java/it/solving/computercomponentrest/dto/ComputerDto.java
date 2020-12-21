package it.solving.computercomponentrest.dto;

import java.util.ArrayList;
import java.util.List;


public class ComputerDto {
	
	private Integer id;

	private String brand;

	private String description;
	
	private List<DeviceDto> componentsDto = new ArrayList<DeviceDto>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<DeviceDto> getComponentsDto() {
		return componentsDto;
	}


	public void setComponentsDto(List<DeviceDto> componentsDto) {
		this.componentsDto = componentsDto;
	}


	
	

}
