package bg.obshtestvo.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import bg.obshtestvo.service.QuestionService;

@Path("questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GET
	@Path("/{id}")
	public Response getUsers(@PathParam("id") int id) {
		
		return Response.ok(questionService.getQuestion(id)) 
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
	
}
