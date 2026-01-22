package service;

import model.AddressBook;
import model.Contact;

import java.util.Map;

// Service layer for business logic
public interface AddressBookService {

    // UC6
    void createAddressBook(String name);

    Map<String, AddressBook> getAllAddressBooks();

    // UC2 / UC5
    void addContact(String bookName, Contact contact);

    // UC3
    boolean editContact(String bookName, String firstName, Contact updated);

    // UC4
    boolean deleteContact(String bookName, String firstName);
}
