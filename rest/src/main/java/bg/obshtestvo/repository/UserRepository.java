package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bg.obshtestvo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
