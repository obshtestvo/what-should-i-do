package bg.obshtestvo.service;

import java.util.List;

import bg.obshtestvo.model.User;

public interface UserService {
	
	User createOrUpdateUser(User user);
	
	void removeUser(int id);
	
	List<User> getAllUsers();
	
	User getUser(int id);
}
