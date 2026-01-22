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

        // UC3: Edit Contact
        System.out.println("\nEdit Contact");
        System.out.print("Enter First Name to Edit: ");
        String editName = scanner.nextLine();

        System.out.print("New Last Name: ");
        String newLastName = scanner.nextLine();

        System.out.print("New Address: ");
        String newAddress = scanner.nextLine();

        System.out.print("New City: ");
        String newCity = scanner.nextLine();

        System.out.print("New State: ");
        String newState = scanner.nextLine();

        System.out.print("New Zip: ");
        String newZip = scanner.nextLine();

        System.out.print("New Phone: ");
        String newPhone = scanner.nextLine();

        System.out.print("New Email: ");
        String newEmail = scanner.nextLine();

        Contact updatedContact = new Contact(
                editName, newLastName,
                newAddress, newCity,
                newState, newZip,
                newPhone, newEmail
        );

        boolean isUpdated =
                service.editContactByName(editName, updatedContact);

        if (isUpdated) {
            System.out.println("Contact updated successfully (UC3).");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
