package bg.obshtestvo.rest;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import bg.obshtestvo.model.ErrorEntity;
import bg.obshtestvo.model.User;
import bg.obshtestvo.service.UserService;



@Component
@Path("users")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	private static String NULL_IS_NOT_VALID_VALUE = "Null is not a valid value for parameter";
	private static int NULL_IS_NOT_VALID_VALUE_STATUS_CODE = 1;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		
		return  BaseController.buildResponse(userService.getAllUsers());
	}
	
	@DenyAll
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		
		return BaseController.buildResponse(userService.getUser(id));
	}
	
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerUser(@Valid User user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(user.getPassword() != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		try {
			return BaseController.buildResponse(userService.createOrUpdateUser(user));
		} catch(ValidationException e) {
			ErrorEntity error = new ErrorEntity();
			error.setMessage(NULL_IS_NOT_VALID_VALUE);
			error.setStatus(NULL_IS_NOT_VALID_VALUE_STATUS_CODE);
			return BaseController.buildErrorResponse(error);
		}	
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
	public Response updateUser(@Valid User user) {
		
		try {
			return BaseController.buildResponse(userService.createOrUpdateUser(user));
		} catch(ValidationException e) {
			ErrorEntity error = new ErrorEntity();
			error.setMessage(NULL_IS_NOT_VALID_VALUE);
			error.setStatus(NULL_IS_NOT_VALID_VALUE_STATUS_CODE);
			return BaseController.buildErrorResponse(error);
		}

		
	}
}
