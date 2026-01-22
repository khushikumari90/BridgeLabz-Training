package repository;

import model.AddressBook;
import model.Contact;

import java.util.Map;

// Repository layer for data handling
public interface AddressBookRepository {

    // UC6: Create Address Book with unique name
    void createAddressBook(String name);

    // UC6: Get Address Book by name
    AddressBook getAddressBook(String name);

    // UC6: Dictionary of Address Books
    Map<String, AddressBook> getAllAddressBooks();

    // UC2 / UC5: Add contact to Address Book
    void addContact(String bookName, Contact contact);

    // UC3: Edit contact
    boolean editContact(String bookName, String firstName, Contact updated);

    // UC4: Delete contact
    boolean deleteContact(String bookName, String firstName);
}
