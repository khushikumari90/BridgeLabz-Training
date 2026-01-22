package repository;

import model.AddressBook;
import model.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBookRepositoryImpl
        implements AddressBookRepository {

    // UC1 storage
    private final List<Contact> contactList = new ArrayList<>();

    // UC2 AddressBook (HAS-A)
    private final AddressBook addressBook = new AddressBook();

    // UC1 implementation
    @Override
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully (UC1).");
    }

    // UC2 implementation
    @Override
    public void addContactUsingAddressBook(Contact contact) {
        addressBook.addContact(contact);
        System.out.println("Contact added successfully using AddressBook (UC2).");
    }
}
