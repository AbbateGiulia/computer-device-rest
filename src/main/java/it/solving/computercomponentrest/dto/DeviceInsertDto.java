package it.solving.computercomponentrest.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class DeviceInsertDto {
	
				
		@NotBlank
		private String brand;
		
		@NotBlank
		private String code;
		
		@NotBlank
		private String description;
		
		@Valid
		private ComputerDto computerDto;

		

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public ComputerDto getComputerDto() {
			return computerDto;
		}

		public void setComputerDto(ComputerDto computerDto) {
			this.computerDto = computerDto;
		}
		
		
		

	}



