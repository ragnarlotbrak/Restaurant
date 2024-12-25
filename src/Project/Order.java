package Project;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private ArrayList<MenuItem> items;

    public Order(int orderId) {
        this.orderID = orderId;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderID;
    }

    public void setOrderId(int orderId) {
        this.orderID = orderId;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void printItems() {
        System.out.println("\nOrder ID: " + orderID);
        System.out.println("\nOrder Items:");
        for (MenuItem item : items) {
            System.out.println(item);
        }
        System.out.println("\nTotal Price: " + getTotalPrice() + " tenge" + "\n" + "\nThank you foe choosing our restaurant!!!");
    }
}