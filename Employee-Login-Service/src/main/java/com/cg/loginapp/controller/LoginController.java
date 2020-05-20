package com.cg.loginapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sprintems")
@Api(value = "LimitConfiguration demo using logger and swagger")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping(value="/registeruser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retrieveLimitsFromConfigurations", nickname = "retrieveLimitsFromConfigurations")
    @ApiResponses(value = {
               @ApiResponse(code = 200, message = "Success", response = User.class),
               @ApiResponse(code = 500, message = "Failure", response = User.class)})
	
	public User addUser(@RequestBody User user) throws Exception {
	
		String tempEmailId=user.getEmailId();
		if(tempEmailId!=null && !"".equals(tempEmailId)){
			User userObj=loginService.getUserByEmailId(tempEmailId);
			if(userObj!=null) {
				logger.info("User with "+tempEmailId+"already exists");
			}
			
		}
		User userObj=null;
		userObj=loginService.addUser(user);
		
		return userObj;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retrieveLimitsFromConfigurations", nickname = "retrieveLimitsFromConfigurations")
    @ApiResponses(value = {
               @ApiResponse(code = 200, message = "Success", response = User.class),
               @ApiResponse(code = 500, message = "Failure", response = User.class)})
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPassword=user.getPassword();
		User userObj=null;
		if(tempEmailId != null && tempPassword!= null) {
			userObj=loginService.getUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(userObj==null) {
			throw new Exception("Bad Credentials");
		}
		
		return userObj;
	}
	
	@GetMapping("/changerole/{userId}")
	public User changeRole(@PathVariable Integer userId) {
		return loginService.roleChange(userId);
	}

}
