package com.loginapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginapp.dto.LogInDTO;
import com.loginapp.dto.UserDTO;
import com.loginapp.entity.User;
import com.loginapp.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<?> logIn(@RequestBody LogInDTO logInDTO) {

		UserDTO dto = userService.userLogin(logInDTO);

		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {

		this.userService.saveUser(userDTO);

		return new ResponseEntity<>("User created", HttpStatus.OK);

	}

}
