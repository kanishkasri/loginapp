package com.loginapp.services;

import java.util.List;

import com.loginapp.dto.VehicleDTO;
import com.loginapp.dto.VehicleVerificationDTO;

public interface VehicleVerificationService {

	public void createVehicleVerification(List<VehicleVerificationDTO> verificationDtos);

	public List<VehicleVerificationDTO> getVehiclesVerifications(Long vehicleId);

	public List<VehicleDTO> getVerificationDetailOfVehicle(Long vehicleId, Long userId);

}
