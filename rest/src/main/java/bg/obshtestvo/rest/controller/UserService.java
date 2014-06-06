package bg.obshtestvo.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import bg.obshtestvo.service.UserController;

@Path("users")
public class UserService {

	@Autowired
	private UserController userController;

	@GET
	public Response getUsers() {
		
		return Response.ok(userController.getGreeting()) 
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
}
