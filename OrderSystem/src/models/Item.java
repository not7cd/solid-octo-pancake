package models;

public abstract class Item implements Comparable<Item> {
    abstract public String getName();
    abstract public int getPrice();

    @Override
    abstract public String toString();

    @Override
    public int compareTo(Item d) {
        return this.getPrice() - d.getPrice();
    }
}
