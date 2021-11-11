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
                case 1: orderService.orderProduct(); break ;
                case 2: orderService.orderService(); break ;
                default: System.out.println("invalid" ); break ;
            }
        } while( input != 0 );

        finishOrder() ;
    }
}
