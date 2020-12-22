package it.solving.computercomponentrest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ComputerGetDto {

	
	@NotNull
	private Integer id;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String description;
	
	

	public ComputerGetDto() {
		super();
	}

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
	
	
	
}
