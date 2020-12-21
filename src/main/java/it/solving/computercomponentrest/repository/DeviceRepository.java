package it.solving.computercomponentrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.solving.computercomponentrest.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
