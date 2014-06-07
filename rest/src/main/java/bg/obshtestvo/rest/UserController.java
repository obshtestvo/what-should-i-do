package bg.obshtestvo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		
		Gson gson = new Gson();
		return Response.ok(gson.toJson(userService.getAllUsers())) 
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		
		Gson gson = new Gson();
		return Response.ok(gson.toJson(userService.getUser(id))) 
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(String user) {
		
		Gson gson = new Gson();
		UserSecurityDetails looser = gson.fromJson(user, UserSecurityDetails.class);
		return Response.ok(gson.toJson(userService.createOrUpdateUser(looser)))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") Integer id) {
		userService.removeUser(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(String user) {
		
		Gson gson = new Gson();
		UserSecurityDetails looser = gson.fromJson(user, UserSecurityDetails.class);
		return Response.ok(gson.toJson(userService.createOrUpdateUser(looser)))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
}
