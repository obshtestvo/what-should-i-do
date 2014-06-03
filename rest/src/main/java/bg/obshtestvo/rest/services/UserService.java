package bg.obshtestvo.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.obshtestvo.rest.controllers.UserController;

@Path("users")
public class UserService {
	
	@Autowired
	private UserController userController;
	
	@GET
	public Response getUsers() {
		return Response.ok(userController.getGreeting()).build();
	}
}
