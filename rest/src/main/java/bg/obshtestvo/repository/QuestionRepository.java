package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.obshtestvo.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
