package bg.obshtestvo.service;

import java.util.List;

import bg.obshtestvo.model.User;

public interface UserService {
	
	/**
	 * Dummy method to test the Jersey-Spring integration
	 * @return
	 */
	String getGreeting();
	
	User createOrUpdateUser(User user);
	
	void removeUser(int id);
	
	List<User> getAllUsers();
	
	User getUser(int id);
}
