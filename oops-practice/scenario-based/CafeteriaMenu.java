package oopsscenariobased;
import java.util.Scanner;

public class CafeteriaMenu {

    static String[] menuItems = {
        "Idli", "Dosa", "Poha", "Sandwich", "Burger",
        "Pizza", "Pasta", "Noodles", "Coffee", "Tea"
    };

    // Method to display menu
    public static void displayMenu() {
        System.out.println("Cafeteria Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " - " + menuItems[i]);
        }
    }

    // Method to get item by index
    public static String getItemByIndex(int index) {
        if (index >= 0 && index < menuItems.length) {
            return menuItems[index];
        } else {
            return "Invalid Selection";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        displayMenu();

        System.out.print("Select item index: ");
        int choice = sc.nextInt();

        String selectedItem = getItemByIndex(choice);
        System.out.println("You selected: " + selectedItem);
        
        sc.close();
    }
}

