package it.solving.computercomponentrest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Computer {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		private String brand;

		private String description;
		
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "computer", cascade= {CascadeType.REMOVE})
		private List<Device> devices = new ArrayList<Device>();
		
		

		public Computer() {
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

		public List<Device> getDevices() {
			return devices;
		}
		
		public void setDevices(List<Device> devices) {
			this.devices = devices;
		}

		
		
		
		

}
