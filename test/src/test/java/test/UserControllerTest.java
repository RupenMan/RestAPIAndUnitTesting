package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import model.UserController;
import service.UserService;
import serviceImpl.UserServiceImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserController.class)
public class UserControllerTest {
	
	private UserServiceImpl userServiceImpl;
	private UserController userController;
	
	@Test
	public void testGetUserCount() {
		UserService mockUserService = PowerMockito.mock(UserServiceImpl.class);
		PowerMockito.when(mockUserService.getUserCount()).thenReturn(100L);
		UserController userController = new UserController(mockUserService);
		assertEquals(100L,userController.getUserCount().longValue());
		
	}
	
}
