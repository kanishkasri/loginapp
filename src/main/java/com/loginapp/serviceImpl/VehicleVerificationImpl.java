package com.loginapp.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginapp.dto.VehicleDTO;
import com.loginapp.dto.VehicleVerificationDTO;
import com.loginapp.entity.User;
import com.loginapp.entity.Vehicle;
import com.loginapp.entity.VehicleVerification;
import com.loginapp.repository.UserRepository;
import com.loginapp.repository.VehicleRepository;
import com.loginapp.repository.VehicleVerificationRepository;
import com.loginapp.services.VehicleVerificationService;

@Service
public class VehicleVerificationImpl implements VehicleVerificationService {

	@Autowired
	UserRepository userRespository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	VehicleVerificationRepository vehicleVerificationRepository;

	@Override
	public void createVehicleVerification(List<VehicleVerificationDTO> dtos) {
		List<VehicleVerification> verifications = dtos.stream().map(dto -> {
			Long id = dto.getVehicleId();
			if (!Objects.isNull(id)) {
				VehicleVerification verification = new VehicleVerification();
				Optional<Vehicle> optVehicle = this.vehicleRepository.findById(id);
				Vehicle vehicle = optVehicle.get();
				verification.setBreaks(dto.isBreaks());
				verification.setLights(dto.isLights());
				verification.setSeatBelt(dto.isSeatBelt());
				verification.setHandBreak(dto.isHandBreak());
				verification.setTyres(dto.isTyres());
				verification.setVehicle(vehicle);
				return verification;
			} else {
				throw new NullPointerException();
			}

		}).collect(Collectors.toList());

		this.vehicleVerificationRepository.saveAll(verifications);
	}

	@Override
	public List<VehicleVerificationDTO> getVehiclesVerifications(Long vehicleId) {
		Optional<Vehicle> optVehicle = this.vehicleRepository.findById(vehicleId);
		Vehicle vehicle = optVehicle.get();
		List<VehicleVerification> verifications = this.vehicleVerificationRepository.findByVehicle(vehicle);
		List<VehicleVerificationDTO> dtos = verifications.stream().map(v -> {
			VehicleVerificationDTO dto = new VehicleVerificationDTO(v.isBreaks(), v.isLights(), v.isSeatBelt(),
					v.isHandBreak(), v.isTyres(), v.getVehicle().getVehicleId());
			return dto;
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<VehicleDTO> getVerificationDetailOfVehicle(Long vehicleId, Long userId) {
		Optional<User> optUser = userRespository.findById(userId);
		User user = optUser.get();
		List<Vehicle> vehicles = this.vehicleRepository.findByVehicleIdAndUser(vehicleId, user);

		List<VehicleDTO> vehicleDTOs = vehicles.stream().map(vehicle -> {
			List<VehicleVerification> verifications = this.vehicleVerificationRepository.findByVehicle(vehicle);
			List<VehicleVerificationDTO> verificationDtos = verifications.stream().map(verify -> {
				VehicleVerificationDTO dto = new VehicleVerificationDTO(verify.isBreaks(), verify.isLights(),
						verify.isSeatBelt(), verify.isHandBreak(), verify.isTyres(),
						verify.getVehicle().getVehicleId());
				return dto;
			}).collect(Collectors.toList());

			VehicleDTO vehicleDto = new VehicleDTO(vehicle.getVehicleId(), vehicle.getName(),
					vehicle.getRegistrationNumber(), vehicle.getBrand(), vehicle.getUser().getUserId(),
					verificationDtos);
			return vehicleDto;
		}).collect(Collectors.toList());
		return vehicleDTOs;
	}

}
