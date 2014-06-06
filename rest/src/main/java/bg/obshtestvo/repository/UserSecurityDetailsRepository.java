package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.obshtestvo.model.UserSecurityDetails;

public interface UserSecurityDetailsRepository extends JpaRepository<UserSecurityDetails, Long> {

}
