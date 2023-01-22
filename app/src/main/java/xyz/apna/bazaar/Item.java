package xyz.apna.bazaar;

public class Item {
    protected String name;
    protected String category;
    protected double price;
    protected double quantity;
    protected String unit;

    public Item(String name_, String category_, double price_, double quantity_, String unit_) {
        name = name_;
        category = category;
        price = price_;
        quantity = quantity_;
        unit = unit_;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public static Item[] load() {
        Item[] items = new Item[5];

        items[0] = new Item("Item 1", "Category 1", 300.0, 3, "units");
        items[1] = new Item("Item 2", "Category 2", 220, 1.2, "kg");
        items[2] = new Item("Item 3", "Category 3", 70, 1.2, "litres");
        items[3] = new Item("Item 4", "Category 4", 20, 1.2, "kg");
        items[4] = new Item("Item 5", "Category 5", 40, 1.2, "gallons");

        return items;
    }
}
