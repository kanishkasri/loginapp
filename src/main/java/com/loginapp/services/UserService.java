package com.loginapp.services;

import com.loginapp.dto.LogInDTO;
import com.loginapp.dto.UserDTO;
import com.loginapp.entity.User;


public interface UserService {
	
	public UserDTO userLogin(LogInDTO dto);
	
	public void saveUser(UserDTO userDTO);

}
