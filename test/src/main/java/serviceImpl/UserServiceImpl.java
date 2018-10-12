package serviceImpl;

import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User getUserById(Long userId) {
		return null;
	}

	@Override
	public void updateUserDetails(User newUserDetails) {
	}

	@Override
	public void createUser(User user) {
	}

	@Override
	public Long getUserCount() {
		throw new UnsupportedOperationException("Operation Not Implemented");
	}
}
