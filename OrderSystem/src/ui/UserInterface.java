package ui;

import enitites.Service;

public abstract class UserInterface {
    protected UserInterface(Service orderService) {
        this.orderService = orderService;
    }

    public abstract void menuloop();

    protected Service orderService;

    protected String formatPrice(int priceInCent) {
        return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
                + priceInCent % 100 + " EUR";
    }
}
