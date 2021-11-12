package storage;

import models.Item;

import java.util.List;

public interface IItemRepository {
    void sort();

    void add(Item product);

    List<Item> getAll();

    List<Item> release();

    void clear();
}
