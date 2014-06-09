package bg.obshtestvo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bg.obshtestvo.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	@Query("select a.id, a.content, a.numberOfVotes, a.score, a.author " +
			"from  Answer as a " +
			"inner join a.items as ia " +
			"where ia.id = :questionId")
	public List<Answer> findForQuestion(Long questionId);
	
	@Query("update Answer a " +
			"set score = score + :score " +
			"where a.id = :answerId")
	public void changeScore(Long answerId, Integer score);
	
	@Query("update Answer a " +
				"set numberOfVotes = numberOfVotes + :validity " +
				"where a.id = :answerId")
	public void updateNumberOfVotes(Long answerId, Integer validity);
}
