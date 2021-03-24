package com.loginapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loginapp.entity.Vehicle;
import com.loginapp.entity.VehicleVerification;

public interface VehicleVerificationRepository extends JpaRepository<VehicleVerification, Long> {

	public List<VehicleVerification> findByVehicle(Vehicle vehicle);

}
