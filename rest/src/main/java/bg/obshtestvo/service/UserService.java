package bg.obshtestvo.service;

import bg.obshtestvo.model.UserSecurityDetails;

public interface UserService {
	
	/**
	 * Dummy method to test the Jersey-Spring integration
	 * @return
	 */
	String getGreeting();
	
	UserSecurityDetails registerUser(UserSecurityDetails user);
}
