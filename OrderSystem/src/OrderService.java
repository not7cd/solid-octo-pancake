import helpers.Input;
import models.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

	private ItemRepository itemRepository = new ItemRepository();
	private ItemFactory factory;

	
	public void orderProduct() {
		System.out.println("Name: ");
		String l = Input.readString();
		System.out.println("Unit price (in cents): ");
		int p = Input.readInt();
		System.out.println("Quantity: ");
		int s = Input.readInt();
		itemRepository.add(factory.createProduct(l, p, s));
	}
	
	public void orderService() {
		System.out.println("Service type: ");
		String l = Input.readString();
		System.out.println("Number of persons: ");
		int p = Input.readInt();
		System.out.println("Hours: ");
		int s = Input.readInt();
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
