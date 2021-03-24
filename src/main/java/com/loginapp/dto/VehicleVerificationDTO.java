package com.loginapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleVerificationDTO {

	private boolean breaks;
	private boolean lights;
	private boolean seatBelt;
	private boolean handBreak;
	private boolean tyres;
	private Long vehicleId;

}
