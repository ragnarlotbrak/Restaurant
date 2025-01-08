package Project;

import Project.MenuItem;
import Project.Restaurant;

import   java.util.ArrayList;

public class OrderFilter{
    public static ArrayList<MenuItem> filterItemsByPrice(Restaurant restaurant, double minPrice) {
        ArrayList<MenuItem> filteredItems = new ArrayList<>();
        for (MenuItem item : restaurant.getMenu()) {
            if (item.getPrice() >= minPrice) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
}