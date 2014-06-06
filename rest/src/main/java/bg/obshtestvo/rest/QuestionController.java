package bg.obshtestvo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import bg.obshtestvo.service.QuestionService;

@Component
@Path("questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GET
	@Path("/{id}")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public Response getUsers(@PathParam("id") int id) {
		
		return Response.ok("penis")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
}
