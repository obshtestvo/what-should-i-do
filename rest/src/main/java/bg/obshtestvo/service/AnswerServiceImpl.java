package bg.obshtestvo.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import bg.obshtestvo.model.Answer;
import bg.obshtestvo.repository.AnswerRepository;

public class AnswerServiceImpl implements AnswerService {

	@Resource
	AnswerRepository answerRepository;
	
	@Override
	public void createOrUpdateAnswer(Answer answer) {
		answerRepository.save(answer);
	}

	@Override
	public void deleteAnswer(Long answerId) {
		answerRepository.delete(answerId);
	}

	@Override
	public List<Answer> findForQuestion(Long questionId) {
		return answerRepository.findForQuestion(questionId);
	}

	@Transactional
	@Override
	public void changeVote(Long answerId, Integer score) {
		answerRepository.changeScore(answerId, score);
		answerRepository.updateNumberOfVotes(answerId, (score == 0) ? -1 : 1);
	}

	@Override
	public Answer findAnswer(Long answerId) {
		return answerRepository.findOne(answerId);
	}

}
