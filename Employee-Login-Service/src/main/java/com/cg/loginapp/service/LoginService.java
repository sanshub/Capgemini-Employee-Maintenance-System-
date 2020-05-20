package com.cg.loginapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	public User getUserByEmailId(String emailId) {
		return userRepository.findUserByEmailId(emailId);
	}
	
	public User getUserByEmailIdAndPassword(String emailId,String password) {
		return userRepository.findUserByEmailIdAndPassword(emailId,password);
	}
	
	public User roleChange(Integer userId) {
		User tempUser = userRepository.findByUserId(userId);
		tempUser.setRole("Manager");
		return userRepository.save(tempUser);
	}
}
