import helpers.Input;
import models.Item;

public class OrderService {

	private final ItemRepository itemRepository = new ItemRepository();
	private ItemFactory factory;

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

		itemRepository.sort();
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
		itemRepository.add(factory.createProduct(l, p, s));
	}
	
	private void orderService() {
		System.out.println("Service type: ");
		String l = Input.readString();
		System.out.println("Number of persons: ");
		int p = Input.readInt();
		System.out.println("Hours: ");
		int s = Input.readInt();
		itemRepository.add(factory.createService(l, p, s));
	}
	
	private void finishOrder() {
		int sum = 0;
		for (Item i : itemRepository.getAll()) {
			sum += i.getPrice();
			System.out.println(i + " = " + formatPrice(i.getPrice()));
		}
		System.out.println("Sum: "+ formatPrice(sum));
		itemRepository.clear();
	}

	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100 + " EUR";
	}

	public void setFactory(ItemFactory factory) {
		this.factory = factory;
	}
}
