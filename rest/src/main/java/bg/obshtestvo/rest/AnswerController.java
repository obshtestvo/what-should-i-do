package bg.obshtestvo.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import bg.obshtestvo.model.Answer;
import bg.obshtestvo.service.AnswerService;

@Path("answers")
public class AnswerController extends BaseController {

	@Autowired	
	AnswerService answerService;

	@POST
	public void createAnswer(Answer answer) {
		answerService.createOrUpdateAnswer(answer);
	}
}
