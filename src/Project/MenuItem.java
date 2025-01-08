package Project;

public class MenuItem {
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private double price;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " => " + price + " tenge";
    }
}