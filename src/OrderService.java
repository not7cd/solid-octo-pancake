import models.Item;
import models.Product;
import models.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderService {

	private List<Item> items = new ArrayList<>();

	public void menuloop() {
		int input;
		do {
			printMenu();
			input = Input.readInt();
			switch ( input ) {
				case 0: break ;
				case 1: orderProduct(); break ;
				case 2: orderService(); break ;
				default: System.out.println("invalid" ); break ;
			}
		} while( input != 0 );

		Collections.sort(items);
		finishOrder() ;
	}
	
	private void printMenu() {
		System.out.println("Your choice?");
		System.out.println("(0) Finish order");
		System.out.println("(1) Order product");
		System.out.println("(2) Order service");
	}
	
	private void orderProduct() {
		System.out.println("Name: ");
		String l = Input.readString();
		System.out.println("Unit price (in cents): ");
		int p = Input.readInt();
		System.out.println("Quantity: ");
		int s = Input.readInt();
		items.add(new Product(l, p, s));
	}
	
	private void orderService() {
		System.out.println("Service type: ");
		String l = Input.readString();
		System.out.println("Number of persons: ");
		int p = Input.readInt();
		System.out.println("Hours: ");
		int s = Input.readInt();
		items.add(new Service(l, p, s));
	}
	
	private void finishOrder() {
		int sum = 0;
		for (Item i : items) {
			sum += i.getPrice();
			System.out.println(i + " = " + formatPrice(i.getPrice()));
		}
		System.out.println("Sum: "+ formatPrice(sum));
	}

	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100 + " EUR";
	}
}
