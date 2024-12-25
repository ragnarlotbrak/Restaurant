package Project;
import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getMenu(){
        return menu;
    }

    public void printMenu() {
        System.out.println("Menu:");
        for (MenuItem menuItem : menu) {
            System.out.println(menuItem);
        }
    }


}