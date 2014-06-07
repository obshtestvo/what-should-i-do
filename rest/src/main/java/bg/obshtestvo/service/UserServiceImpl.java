package bg.obshtestvo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bg.obshtestvo.model.UserSecurityDetails;
import bg.obshtestvo.repository.UserSecurityDetailsRepository;

@Component
public class UserServiceImpl implements UserService {

	@Resource
	private UserSecurityDetailsRepository userDetailsRepository;
	
	@Override
	public String getGreeting() {
		return "Hello, beautiful!";
	}

	@Override
	public UserSecurityDetails createOrUpdateUser(UserSecurityDetails user) {
		
		return userDetailsRepository.save(user);
	}

	@Override
	public void removeUser(int id) {
		
		userDetailsRepository.delete((long) id);
	}

	@Override
	public List<UserSecurityDetails> getAllUsers() {
		
		return userDetailsRepository.findAll();
	}

	@Override
	public UserSecurityDetails getUser(int id) {
		
		return userDetailsRepository.findOne((long) id);
	}
}
