package com.loginapp.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDTO {

	private Long vehicleId;
	private String name;
	private String registrationNumber;
	private String brand;
	private Long userId;
	List<VehicleVerificationDTO> verificationDtos;

	public VehicleDTO(Long vehicleId, String name, String registrationNumber, String brand, Long userId) {
		this.vehicleId = vehicleId;
		this.name = name;
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.userId = userId;
	}

	public VehicleDTO(Long vehicleId, String name, String registrationNumber, String brand, Long userId,
			List<VehicleVerificationDTO> verificationDtos) {
		this.vehicleId = vehicleId;
		this.name = name;
		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.userId = userId;
		this.verificationDtos = verificationDtos;
	}

}
