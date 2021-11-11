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
		itemRepository.sort();
		List<Item> all;
		all = new ArrayList<>(itemRepository.getAll());
		itemRepository.clear();
		return all;
	}

	public void setFactory(ItemFactory factory) {
		this.factory = factory;
	}
}
