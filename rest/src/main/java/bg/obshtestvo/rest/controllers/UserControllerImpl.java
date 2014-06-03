package bg.obshtestvo.rest.controllers;

import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {

	@Override
	public String getGreeting() {
		return "Hello, beautiful!";
	}
	
}
