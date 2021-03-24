package com.loginapp.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginapp.dto.VehicleDTO;
import com.loginapp.entity.User;
import com.loginapp.entity.Vehicle;
import com.loginapp.repository.UserRepository;
import com.loginapp.repository.VehicleRepository;
import com.loginapp.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	UserRepository userRespository;

	@Override
	public void createVehicle(VehicleDTO dto) {

		Vehicle vehicle = new Vehicle();

		Long id = dto.getUserId();
		if (!Objects.isNull(id)) {

			Optional<User> optUser = this.userRespository.findById(id);
			User user = optUser.get();

			vehicle.setName(dto.getName());
			vehicle.setRegistrationNumber(dto.getRegistrationNumber());
			vehicle.setBrand(dto.getBrand());
			vehicle.setUser(user);

			this.vehicleRepository.save(vehicle);
		} else {
			throw new NullPointerException();
		}

	}

	@Override
	public List<VehicleDTO> getVehicles(Long userId) {
		Optional<User> optUser = userRespository.findById(userId);
		User user = optUser.get();
		List<Vehicle> vehicles = this.vehicleRepository.findByUser(user);
		List<VehicleDTO> vehicleDTOs = vehicles.stream().map(vehicle -> {
			VehicleDTO dto = new VehicleDTO(vehicle.getVehicleId(), vehicle.getName(), vehicle.getRegistrationNumber(),
					vehicle.getBrand(), vehicle.getUser().getUserId());
			return dto;
		}).collect(Collectors.toList());
		return vehicleDTOs;
	}

}
