package bg.obshtestvo.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public String getGreeting() {
		return "Hello, beautiful!";
	}
	
}
