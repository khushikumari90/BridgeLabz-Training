package repository;

import model.AddressBook;
import model.Contact;

import java.util.HashMap;
import java.util.Map;

// Repository implementation
// Handles persistence of Address Books and Contacts
public class AddressBookRepositoryImpl implements AddressBookRepository {

    // UC6: Dictionary to maintain multiple Address Books
    // Key   -> Address Book Name
    // Value -> AddressBook object
    private final Map<String, AddressBook> addressBookMap = new HashMap<>();

    // UC6: Create a new Address Book with unique name
    @Override
    public void createAddressBook(String name) {
        addressBookMap.putIfAbsent(name, new AddressBook());
    }

    // UC6: Fetch Address Book by name
    @Override
    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    // UC6: Get all Address Books
    @Override
    public Map<String, AddressBook> getAllAddressBooks() {
        return addressBookMap;
    }

    // UC1, UC2, UC5, UC7:
    // Add contact to Address Book
    // Duplicate check is handled inside AddressBook (UC7)
    @Override
    public void addContact(String bookName, Contact contact) {
        AddressBook addressBook = addressBookMap.get(bookName);

        if (addressBook != null) {
            addressBook.addContact(contact);
        }
    }

    // UC3: Edit existing contact using person's name
    @Override
    public boolean editContact(String bookName, String firstName, Contact updated) {
        AddressBook addressBook = addressBookMap.get(bookName);

        if (addressBook != null) {
            return addressBook.editContact(firstName, updated);
        }
        return false;
    }

    // UC4: Delete contact using person's name
    @Override
    public boolean deleteContact(String bookName, String firstName) {
        AddressBook addressBook = addressBookMap.get(bookName);

        if (addressBook != null) {
            return addressBook.deleteContact(firstName);
        }
        return false;
    }
}
