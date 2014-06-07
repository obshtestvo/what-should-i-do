package bg.obshtestvo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import bg.obshtestvo.model.UserSecurityDetails;
import bg.obshtestvo.service.UserService;

import com.google.gson.Gson;

@Component
@Path("users")
public class UserController {

	@Autowired
	private UserService userService;
//	@Autowired
//	private UserSecurityDetails userSecurityDetailsService;

	@GET
	public Response getUsers() {
		
		return Response.ok(userService.getGreeting()) 
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/register")
	public Response registerUser(String user) {
		
		Gson gson = new Gson();
		UserSecurityDetails looser = gson.fromJson(user, UserSecurityDetails.class);
		return Response.ok(userService.registerUser(looser), MediaType.APPLICATION_JSON)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
//		return Response.serverError().build();
	}
}
