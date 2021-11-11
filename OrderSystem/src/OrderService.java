import helpers.Input;
import models.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

	private ItemRepository itemRepository = new ItemRepository();
	private ItemFactory factory;

	
	public void orderProduct(String l, int p, int s) {
		itemRepository.add(factory.createProduct(l, p, s));
	}
	
	public void orderService(String l, int p, int s) {
		itemRepository.add(factory.createService(l, p, s));
	}
	
	public List<Item> finishOrder() {
		List<Item> all = new ArrayList<>(getOrder());
		itemRepository.clear();
		return all;
	}

	public void setFactory(ItemFactory factory) {
		this.factory = factory;
	}

	public List<Item> getOrder() {
		itemRepository.sort();
		return itemRepository.getAll();
	}
}
