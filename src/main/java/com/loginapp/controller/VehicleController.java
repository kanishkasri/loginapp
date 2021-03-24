package com.loginapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginapp.dto.VehicleDTO;
import com.loginapp.dto.VehicleVerificationDTO;
import com.loginapp.enums.Status;
import com.loginapp.services.VehicleService;
import com.loginapp.services.VehicleVerificationService;

@RestController
public class VehicleController {

	private @Autowired VehicleService vehicleservice;

	private @Autowired VehicleVerificationService vehicleVerificationService;

	@RequestMapping(value = "/createVehicle", method = RequestMethod.POST)
	public ResponseEntity<? extends Object> createVehicles(@RequestBody VehicleDTO vehicleDTO) {
		this.vehicleservice.createVehicle(vehicleDTO);
		return new ResponseEntity<Object>(Status.SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public ResponseEntity<? extends Object> getVehicles(@RequestParam Long userId) {
		List<VehicleDTO> dtos = this.vehicleservice.getVehicles(userId);
		return new ResponseEntity<List<VehicleDTO>>(dtos, HttpStatus.OK);
	}

	
	//creating vehicleVerification
	@RequestMapping(value = "/createVehicleVerification", method = RequestMethod.POST)
	public ResponseEntity<? extends Object> createVehiclesVerification(
			@RequestBody List<VehicleVerificationDTO> verificationDtos) {
		this.vehicleVerificationService.createVehicleVerification(verificationDtos);
		return new ResponseEntity<Object>(Status.SUCCESS, HttpStatus.OK);
	}

	//getting verification Parameters
	@RequestMapping(value = "/vehicleVerifications", method = RequestMethod.GET)
	public ResponseEntity<? extends Object> getVehiclesVerifications(@RequestParam Long vehicleId) {
		List<VehicleVerificationDTO> dtos = this.vehicleVerificationService.getVehiclesVerifications(vehicleId);
		return new ResponseEntity<List<VehicleVerificationDTO>>(dtos, HttpStatus.OK);
	}
	
	//fetching Vehicle and Verification parameters
	@RequestMapping(value = "/verificationDetailOfVehicle", method = RequestMethod.GET)
	public ResponseEntity<? extends Object> getVerificationDetailOfVehicle(@RequestParam Long vehicleId,
			@RequestParam Long userId) {
		List<VehicleDTO> dtos = this.vehicleVerificationService.getVerificationDetailOfVehicle(vehicleId, userId);
		return new ResponseEntity<Object>(dtos, HttpStatus.OK);
	}

}
