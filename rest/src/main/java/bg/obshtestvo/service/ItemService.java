package bg.obshtestvo.service;

import java.util.List;

import bg.obshtestvo.model.Answer;
import bg.obshtestvo.model.Item;

public interface ItemService {
	List<Item> findItems(String searchString);
	
	void createOrUpdateItem(Item item);
	
	void removeItem(Long itemId);
	
	Item findItem(Long itemId);
	
	List<Item> findAllItems();
	
	List<Answer> findAnswersForItem(Long itemId);
}
