package bg.obshtestvo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("users")
public class UserService {
	
	@GET
	public Response getUsers() {
		return Response.ok("hello").build();
	}

}
