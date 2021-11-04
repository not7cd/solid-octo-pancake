import models.Product;
import models.Service;

public class SimpleItemFactory implements ItemFactory{
    @Override
    public Product createProduct(String name, int price, int qty) {
        return new Product(name, price, qty);
    }

    @Override
    public Service createService(String name, int ppl, int hrs) {
        return new Service(name, ppl, hrs);
    }
}
