import models.Product;
import models.Service;

public interface ItemFactory {
    public Product createProduct(String name, int price, int qty);
    public Service createService(String name, int ppl, int hrs);
}
