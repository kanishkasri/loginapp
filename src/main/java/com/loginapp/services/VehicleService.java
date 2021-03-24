package com.loginapp.services;

import java.util.List;

import com.loginapp.dto.VehicleDTO;

public interface VehicleService {

	public void createVehicle(VehicleDTO dto);

	List<VehicleDTO> getVehicles(Long userId);

}
