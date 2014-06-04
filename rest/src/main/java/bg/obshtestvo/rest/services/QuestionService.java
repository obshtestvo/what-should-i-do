package bg.obshtestvo.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import bg.obshtestvo.rest.controllers.QuestionController;

@Path("questions")
public class QuestionService {

	@Autowired
	private QuestionController questionController;
	
	@GET
	@Path("/{id}")
	public Response getUsers(@PathParam("id") int id) {
		
		return Response.ok(questionController.getQuestion(id)) 
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
}
