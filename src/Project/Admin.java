package Project;

public class Admin extends User {
    public Admin(String username) {
        super(username, "admin");
    }

    public void manageMenu(Restaurant restaurant, MenuItem newItem) {
        restaurant.addMenuItem(newItem);
        System.out.println("\nNew menu item added to restaurant " + newItem);
    }
}