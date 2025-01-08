import Project.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin("Admin228");
        System.out.println("\nWelcome, " + admin);

        ArrayList<Restaurant> restaurants = DataInit.createRestaurants();

        restaurants.sort(new RestaurantComparator());
        System.out.println("\nRestaurants:");
        int j = 1;
        for (Restaurant restaurant : restaurants) {
            System.out.println(j + " " + restaurant.getName());
            j++;
        }

        double minPrice = 5000.00;
        ArrayList<MenuItem> expensiveItems = new ArrayList<>(OrderFilter.filterItemsByPrice(restaurants.get(0), minPrice));
        System.out.println("\nItems priced above " + minPrice + " tenge:");
        for (MenuItem item : expensiveItems) {
            System.out.println(item);
        }

        admin.manageMenu(restaurants.get(0), new MenuItem("Tiramisu", 4000.00));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRestaurants:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
        }

        System.out.print("\nChoose a restaurant you would like to visit (1-3): ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > restaurants.size()) {
            System.out.println("Invalid choice");
            return;
        }

        Restaurant selectedRestaurant = restaurants.get(choice - 1);
        System.out.println("\nSelected restaurant: " + selectedRestaurant.getName());
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