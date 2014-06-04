package bg.obshtestvo.dao;

import java.util.List;
import bg.obshtestvo.models.Question;

public interface QuestionDAO {
	public void insertQuestion();
	public List<Question> getQuestionsList();
	public void updateQuestion(Question question);  
	public void deleteQuestion(int id);  
	public Question getQuestion(int id); 
}
