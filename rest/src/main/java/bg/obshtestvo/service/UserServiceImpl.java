package bg.obshtestvo.service;

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
	public UserSecurityDetails registerUser(UserSecurityDetails user) {
		
		return userDetailsRepository.save(user);
	}
}
