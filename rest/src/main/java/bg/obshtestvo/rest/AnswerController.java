package bg.obshtestvo.rest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import bg.obshtestvo.model.Answer;
import bg.obshtestvo.service.AnswerService;

@Path("answers")
@PermitAll
public class AnswerController extends BaseController {

	@Autowired	
	AnswerService answerService;

	@POST
	@RolesAllowed({"ADMIN","USER"})
	public void createAnswer(Answer answer) {
		answerService.createOrUpdateAnswer(answer);
	}
	
	@GET
	@Path("/{id}")
	public Response getAnswer(@PathParam("id") Long answerId) {
		return Response.ok(answerService.findAnswer(answerId))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + "; charset=utf-8")
				.build();
	}
}
