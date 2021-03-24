package com.loginapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "breaks")
	private boolean breaks;

	@Column(name = "lights")
	private boolean lights;

	@Column(name = "seat_belt")
	private boolean seatBelt;

	@Column(name = "hand_breaks")
	private boolean handBreak;

	@Column(name = "tyres")
	private boolean tyres;

	@ManyToOne
	@JoinColumn(name = "vehicle_fk")
	private Vehicle vehicle;

}
