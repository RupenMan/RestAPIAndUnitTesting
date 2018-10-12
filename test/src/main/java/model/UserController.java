package model;

import service.UserService;

public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public Long getUserCount() {
		return userService.getUserCount();
	}
}
