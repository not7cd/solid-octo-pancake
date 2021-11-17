package enitites;

import models.Item;
import storage.ItemRepository;

import java.util.List;

class OrderService implements enitites.Service {

    private ItemRepository itemRepository = new ItemRepository();
    private ItemFactory factory;


    @Override
    public void orderProduct(String l, int p, int s) {
        itemRepository.add(factory.createProduct(l, p, s));
    }

    @Override
    public void orderService(String l, int p, int s) {
        itemRepository.add(factory.createService(l, p, s));
    }

    @Override
    public List<Item> finishOrder() {
        return itemRepository.release();
    }

    @Override
    public void setFactory(ItemFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Item> getOrder() {
        itemRepository.sort();
        return itemRepository.getAll();
    }
}