package com.cg.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loginapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByEmailId(String emailId);

	public User findUserByEmailIdAndPassword(String emailId, String password);

	public User findByUserId(Integer userId);

	
	
}
