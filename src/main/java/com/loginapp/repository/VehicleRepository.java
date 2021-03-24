package com.loginapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginapp.entity.User;
import com.loginapp.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public List<Vehicle> findByUser(User user);
	public List<Vehicle> findByVehicleId(Long id);
	public List<Vehicle> findByVehicleIdAndUser(Long id, User user);

}
