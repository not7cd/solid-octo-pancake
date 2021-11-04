

public class OrderSystemMain {
	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		ItemFactory f = new SimpleItemFactory();
		orderService.setFactory(f);
		orderService.menuloop();
	}
}
