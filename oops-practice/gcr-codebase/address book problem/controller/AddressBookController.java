package controller;

import model.Contact;
import service.AddressBookService;
import service.AddressBookServiceImpl;

import java.util.Scanner;

public class AddressBookController {

    private final AddressBookService service =
            new AddressBookServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void createContact() {

        System.out.print("Enter First Name: ");
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
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(
                firstName, lastName, address,
                city, state, zip,
                phoneNumber, email
        );

        service.addContact(contact);
    }
}
