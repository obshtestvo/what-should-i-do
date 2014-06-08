package bg.obshtestvo.service;

import java.util.List;

import javax.transaction.Transactional;

import bg.obshtestvo.model.Answer;

public interface AnswerService {
	public void createOrUpdateAnswer(Answer answer);

	public void deleteAnswer(Long answerId);

	public List<Answer> findForQuestion(Long questionId);

	@Transactional
	public void changeVote(Long answerId, Integer score);
	
	public Answer findAnswer(Long answerId);
}
