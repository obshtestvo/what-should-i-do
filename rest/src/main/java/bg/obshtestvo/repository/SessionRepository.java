package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.obshtestvo.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
