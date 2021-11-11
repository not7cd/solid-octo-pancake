public abstract class UserInterface {
    protected UserInterface(OrderService orderService) {
        this.orderService = orderService;
    }

    public abstract void menuloop();

    protected OrderService orderService;

    protected String formatPrice(int priceInCent) {
        return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
                + priceInCent % 100 + " EUR";
    }
}
