import java.util.Objects;

public class OrderSystemMain {
	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		ItemFactory f = new SimpleItemFactory();
		orderService.setFactory(f);
		UserInterface userInterface;

		if (args.length >= 1) {
			if (Objects.equals(args[0], "gui")) {
				userInterface = new GUI(orderService);
			} else if (Objects.equals(args[0], "cli")) {
				userInterface = new CLI(orderService);
			} else {
				System.out.println("Pass parameter gui or cli");
				return;
			}
		} else {
			System.out.println("Pass parameter gui or cli");
			return;
		}
		userInterface.menuloop();
	}
}
