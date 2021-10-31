package models;

public class Service extends Item {

	private int factor = 1242;

	private String name;
	private int hours, persons;

	public Service(String n, int p, int s) {
		name = n;
		hours = s;
		persons = p;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return factor * hours * persons;
	}

	@Override
	public String toString() {
		return persons + " persons for " + hours + "h of " + getName();
	}
}
