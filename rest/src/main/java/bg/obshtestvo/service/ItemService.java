package bg.obshtestvo.service;

import java.util.List;

import bg.obshtestvo.model.Item;

public interface ItemService {
	List<Item> findItems(String searchString);
	
	void createOrUpdateItem(Item item);
	
	void removeItem(Long itemId);
}
