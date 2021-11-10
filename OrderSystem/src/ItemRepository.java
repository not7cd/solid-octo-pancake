import models.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemRepository {
    private List<Item> items = new ArrayList<>();

    public ItemRepository() {
    }

    public void sort() {
        Collections.sort(items);
    }

    public void add(Item product) {
        items.add(product);
    }

    public List<Item> getAll() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}