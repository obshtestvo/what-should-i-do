package bg.obshtestvo.service;

import bg.obshtestvo.model.Item;

public interface ItemService {
	String findItem(String searchString);
	
	void createOrUpdateItem(Item item);
	
	void removeItem(Item item);
}
