package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bg.obshtestvo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User where username = :username")
	User findByUsername(String username);
}
