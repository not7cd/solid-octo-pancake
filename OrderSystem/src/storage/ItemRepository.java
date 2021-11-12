package storage;

import models.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemRepository implements IItemRepository {
    private List<Item> items = new ArrayList<>();

    public ItemRepository() {
    }

    @Override
    public void sort() {
        Collections.sort(items);
    }

    @Override
    public void add(Item product) {
        items.add(product);
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void clear() {
        items.clear();
    }

    public List<Item> release() {
        List<Item> result = items;
        items = new ArrayList<>();
        return result;
    }
}