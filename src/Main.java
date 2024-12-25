import Project.MenuItem;
import Project.Order;
import Project.Restaurant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant1 = new Restaurant("Italian cuisine");
        Restaurant restaurant2 = new Restaurant("Russian food world");
        Restaurant restaurant3 = new Restaurant("Kazakh yurt - food");

        restaurant1.addMenuItem(new MenuItem("Pizza_Mozzarella", 2499.99));
        restaurant1.addMenuItem(new MenuItem("Carbonara_Pasta", 4999.99));
        restaurant1.addMenuItem(new MenuItem("Cannelloni", 7800.50));

        restaurant2.addMenuItem(new MenuItem("Borsch", 1499.99));
        restaurant2.addMenuItem(new MenuItem("Pelmeni", 999.00));
        restaurant2.addMenuItem(new MenuItem("Schi", 5490.99));

        restaurant3.addMenuItem(new MenuItem("Beshbarmaq", 29990.00));
        restaurant3.addMenuItem(new MenuItem("Syrne", 17000.00));
        restaurant3.addMenuItem(new MenuItem("Quyrdaq", 5490.50));

        System.out.println("\nRestaurants: ");
        System.out.println("1. " + restaurant1.getName());
        System.out.println("2. " + restaurant2.getName());
        System.out.println("3. " + restaurant3.getName());

        System.out.print("\nChoose a restaurant you would like to visit (1-3): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Restaurant selectedRestaurant;

        if (choice == 1) {
            selectedRestaurant = restaurant1;
        }
        else if (choice == 2) {
            selectedRestaurant = restaurant2;
        }
        else if (choice == 3) {
            selectedRestaurant = restaurant3;
        }
        else {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println("\nSelected restautant: " + selectedRestaurant.getName());
        selectedRestaurant.printMenu();

        Order order = new Order(1);
        System.out.println("\nYour initial order ID: " + order.getOrderId());
        System.out.print("Would you like to make change order ID? (yes/no): ");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("\nWrite new order ID: ");
            int orderId = scanner.nextInt();
            order.setOrderId(orderId);
            System.out.println("Your new order ID: " + orderId);
        }


        System.out.println("\nEnter dishes you would like to order (if you have done enter 'done' to finish):");

        int k = 1;
        while (true) {
            System.out.print("Enter a " + k + " food's name: ");
            String itemName = scanner.next();
            k++;
            if (itemName.equals("done")) {
                break;
            }

            boolean Found = false;
            for (MenuItem item : selectedRestaurant.getMenu()) {
                if (item.getName().equals(itemName)) {
                    Found = true;
                    order.addItem(item);
                    break;
                }
            }

            if (!Found) {
                System.out.println("No item found, try again");
            }
        }

        System.out.println("\n" +
                "\n" +
                "Order Details:");
        order.printItems();
    }
}