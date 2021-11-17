package enitites;

import models.Item;
import models.Product;
import models.Service;
import storage.ItemRepository;

import java.util.List;

public interface ItemFactory {
    Product createProduct(String name, int price, int qty);
    Service createService(String name, int ppl, int hrs);
}
