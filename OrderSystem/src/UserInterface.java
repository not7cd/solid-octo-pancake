public abstract class UserInterface {
    protected UserInterface(OrderService orderService) {
        this.orderService = orderService;
    }

    public abstract void menuloop();

    protected OrderService orderService;
}
