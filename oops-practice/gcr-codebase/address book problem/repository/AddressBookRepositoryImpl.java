package repository;

import model.AddressBook;
import model.Contact;

import java.util.HashMap;
import java.util.Map;

// Repository implementation
public class AddressBookRepositoryImpl
        implements AddressBookRepository {

    // UC6: Dictionary of AddressBook name → AddressBook
    private final Map<String, AddressBook> addressBookMap = new HashMap<>();

    @Override
    public void createAddressBook(String name) {
        addressBookMap.putIfAbsent(name, new AddressBook());
    }

    @Override
    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    @Override
    public Map<String, AddressBook> getAllAddressBooks() {
        return addressBookMap;
    }

    @Override
    public void addContact(String bookName, Contact contact) {
        addressBookMap.get(bookName).addContact(contact);
    }

    @Override
    public boolean editContact(String bookName, String firstName, Contact updated) {
        return addressBookMap.get(bookName)
                .editContact(firstName, updated);
    }

    @Override
    public boolean deleteContact(String bookName, String firstName) {
        return addressBookMap.get(bookName)
                .deleteContact(firstName);
    }
}
