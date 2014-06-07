package bg.obshtestvo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import bg.obshtestvo.model.Item;
import bg.obshtestvo.repository.ItemRepository;

@Component
public class ItemServiceImpl implements ItemService{
	
	@Resource
	ItemRepository itemRepository;
	
	@Override
	public String findItem(String searchString) {
		return null;
	}

	@Override
	public void createOrUpdateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void removeItem(Item item) {
		itemRepository.delete(item);
	}

}
