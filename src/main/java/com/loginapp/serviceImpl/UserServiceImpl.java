package com.loginapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginapp.dto.LogInDTO;
import com.loginapp.dto.UserDTO;
import com.loginapp.entity.User;
import com.loginapp.repository.UserRepository;
import com.loginapp.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	UserDTO userDTO = new UserDTO();

	@Override
	public UserDTO userLogin(LogInDTO dto) {
	

		String email = dto.getEmail();
		String password = dto.getPassword();

		User user = userRepository.findByEmailAndPassword(email, password);

		if (user != null) {

			
			userDTO.setUserId(user.getUserId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			return userDTO;
		}
		else {			
			throw new NullPointerException();
		}

		

	}

	@Override
	public void saveUser(UserDTO userDTO) {
		
		User user = new User();
		
		if(userDTO !=null ) {
			user.setEmail(userDTO.getEmail());
			user.setName(userDTO.getName());
			user.setPassword(userDTO.getPassword());
			
		this.userRepository.save(user);
		}
	
		
	}
	

	
	

}
