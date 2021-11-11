import helpers.Input;
import models.Item;

public class CLI extends UserInterface {

    public CLI(OrderService orderService) {
        super(orderService);
    }


    private void printMenu() {
        System.out.println("Your choice?");
        System.out.println("(0) Finish order");
        System.out.println("(1) Order product");
        System.out.println("(2) Order service");
    }

    public void orderProduct() {
        System.out.println("Name: ");
        String l = Input.readString();
        System.out.println("Unit price (in cents): ");
        int p = Input.readInt();
        System.out.println("Quantity: ");
        int s = Input.readInt();

        orderService.orderProduct(l,p,s);
    }

    public void orderService() {
        System.out.println("Service type: ");
        String l = Input.readString();
        System.out.println("Number of persons: ");
        int p = Input.readInt();
        System.out.println("Hours: ");
        int s = Input.readInt();

        orderService.orderService(l,p,s);
    }



    private void finishOrder(){
        int sum = 0;
        for (Item i : orderService.finishOrder()) {
            sum += i.getPrice();
            System.out.println(i + " = " + formatPrice(i.getPrice()));
        }
        System.out.println("Sum: "+ formatPrice(sum));
    }

    @Override
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

        finishOrder() ;
    }
}
