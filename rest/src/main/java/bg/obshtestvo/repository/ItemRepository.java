package bg.obshtestvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.obshtestvo.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
