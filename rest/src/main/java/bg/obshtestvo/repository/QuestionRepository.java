package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.obshtestvo.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
