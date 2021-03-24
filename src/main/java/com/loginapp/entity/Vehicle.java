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
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long vehicleId;

	@Column(name = "vehicle_name")
	private String name;

	@Column(name = "registration_num")
	private String registrationNumber;

	@Column(name = "brand")
	private String brand;

	@ManyToOne
	@JoinColumn(name = "user_fk")
	private User user;

}
