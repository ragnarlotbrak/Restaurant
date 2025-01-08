package Project;

import java.util.ArrayList;

public class DataInit {
    public static ArrayList<Restaurant> createRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

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

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);

        return restaurants;
    }
}