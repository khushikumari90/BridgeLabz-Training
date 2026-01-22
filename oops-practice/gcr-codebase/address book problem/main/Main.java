package main;

import model.Contact;
import service.AddressBookService;
import service.AddressBookServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBookService service = new AddressBookServiceImpl();

        // Add Contact (UC1 + UC2)
        System.out.println("Add Contact");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

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

        Contact contact = new Contact(
                firstName, lastName,
                address, city, state,
                zip, phone, email
        );

        service.addContact(contact);
        service.addContactUsingAddressBook(contact);

        // UC4: Delete Contact
        System.out.println("\nDelete Contact");
        System.out.print("Enter First Name to Delete: ");
        String deleteName = scanner.nextLine();

        boolean isDeleted = service.deleteContactByName(deleteName);

        if (isDeleted) {
            System.out.println("Contact deleted successfully (UC4).");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
