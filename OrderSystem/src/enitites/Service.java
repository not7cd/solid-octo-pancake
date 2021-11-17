package enitites;

import models.Item;

import java.util.List;

public interface Service {
    void orderProduct(String l, int p, int s);

    void orderService(String l, int p, int s);

    List<Item> finishOrder();

    void setFactory(ItemFactory factory);

    List<Item> getOrder();
}
