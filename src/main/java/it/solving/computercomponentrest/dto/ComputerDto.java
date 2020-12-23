package it.solving.computercomponentrest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



public class ComputerDto {
	
	@NotNull
	private Integer id;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String description;
	
	
	@Valid
	@NotEmpty
	private List<DeviceDto> devicesDto = new ArrayList<DeviceDto>();


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


	public List<DeviceDto> getDevicesDto() {
		return devicesDto;
	}


	public void setDevicesDto(List<DeviceDto> devicesDto) {
		this.devicesDto = devicesDto;
	}


	
	

}
