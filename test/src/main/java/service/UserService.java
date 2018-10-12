package service;

import model.User;

public interface UserService {
	public User getUserById(Long userId);
	public void updateUserDetails(User newUserDetails);
	public void createUser(User user);
	public Long getUserCount();
}
