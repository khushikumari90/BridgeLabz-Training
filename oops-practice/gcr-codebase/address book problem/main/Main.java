package main;

import controller.AddressBookController;
import model.Contact;

import java.util.Scanner;

// Main class uses Controller (NOT Service directly)
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBookController controller = new AddressBookController();

        // UC6: Create Address Book
        System.out.print("Enter Address Book Name: ");
        String bookName = scanner.nextLine();
        controller.createAddressBook(bookName);

        while (true) {
            System.out.println("\n1. Add Contact (UC1, UC2, UC5)");
            System.out.println("2. Edit Contact (UC3)");
            System.out.println("3. Delete Contact (UC4)");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                // UC1
                System.out.print("First Name: ");
                String first = scanner.nextLine();
                System.out.print("Last Name: ");
                String last = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("City: ");
                String city = scanner.nextLine();
                System.out.print("State: ");
                String state = scanner.nextLine();
                System.out.print("Zip: ");
                String zip = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                controller.addContact(bookName,
                        new Contact(first, last, address, city, state, zip, phone, email));
            }
            else if (choice == 2) {
                // UC3
                System.out.print("Enter First Name to Edit: ");
                String first = scanner.nextLine();

                System.out.print("New Last Name: ");
                String last = scanner.nextLine();
                System.out.print("New Address: ");
                String address = scanner.nextLine();
                System.out.print("New City: ");
                String city = scanner.nextLine();
                System.out.print("New State: ");
                String state = scanner.nextLine();
                System.out.print("New Zip: ");
                String zip = scanner.nextLine();
                System.out.print("New Phone: ");
                String phone = scanner.nextLine();
                System.out.print("New Email: ");
                String email = scanner.nextLine();

                controller.editContact(bookName, first,
                        new Contact(first, last, address, city, state, zip, phone, email));
            }
            else if (choice == 3) {
                // UC4
                System.out.print("Enter First Name to Delete: ");
                String first = scanner.nextLine();
                controller.deleteContact(bookName, first);
            }
            else {
                break;
            }
        }
    }
}
