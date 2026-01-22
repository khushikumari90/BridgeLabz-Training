package main;

import model.Contact;
import service.AddressBookService;
import service.AddressBookServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBookService service = new AddressBookServiceImpl();

        System.out.println("Add Multiple Contacts to Address Book");

        while (true) {

            System.out.print("\nEnter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter State: ");
            String state = scanner.nextLine();

            System.out.print("Enter Zip: ");
            String zip = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            Contact contact = new Contact(
                    firstName, lastName,
                    address, city, state,
                    zip, phone, email
            );

            // UC5: add multiple contacts
            service.addContactUsingAddressBook(contact);

            System.out.print("\nDo you want to add another contact? (yes/no): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nAll contacts added successfully.");
    }
}
