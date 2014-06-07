package bg.obshtestvo.service;

import java.util.List;

import bg.obshtestvo.model.UserSecurityDetails;

public interface UserService {
	
	/**
	 * Dummy method to test the Jersey-Spring integration
	 * @return
	 */
	String getGreeting();
	
	UserSecurityDetails createOrUpdateUser(UserSecurityDetails user);
	
	void removeUser(int id);
	
	List<UserSecurityDetails> getAllUsers();
	
	UserSecurityDetails getUser(int id);
}
