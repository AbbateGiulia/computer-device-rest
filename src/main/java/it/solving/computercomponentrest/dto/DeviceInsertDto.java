package it.solving.computercomponentrest.dto;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class DeviceInsertDto {
	
				
		@NotEmpty
		@NotNull
		private String brand;
		
		@NotEmpty
		@NotNull
		private String code;
		
		@NotEmpty
		@NotNull
		private String description;
		
		
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



