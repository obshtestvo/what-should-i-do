package bg.obshtestvo.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.obshtestvo.dao.QuestionDAOImpl;
import bg.obshtestvo.models.Question;

@Component
public class QuestionControllerImpl implements QuestionController{

	@Autowired
	private QuestionDAOImpl questionDAO; 
	
	@Override
	public String getQuestion(int id) {
		Question question = questionDAO.getQuestion(id);
		return question.getQuestionName();
	}

}
