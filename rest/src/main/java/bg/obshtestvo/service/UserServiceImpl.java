package bg.obshtestvo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bg.obshtestvo.model.User;
import bg.obshtestvo.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	
	@Override
	public String getGreeting() {
		return "Hello, beautiful!";
	}

	@Override
	public User createOrUpdateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void removeUser(int id) {
		
		userRepository.delete((long) id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(int id) {
		
		return userRepository.findOne((long) id);
	}
}
