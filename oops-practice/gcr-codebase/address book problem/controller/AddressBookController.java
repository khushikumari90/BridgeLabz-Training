package controller;

import model.AddressBook;
import model.Contact;
import service.AddressBookService;
import service.AddressBookServiceImpl;

import java.util.Map;

// Controller layer: connects Main with Service
public class AddressBookController {

    private final AddressBookService service =
            new AddressBookServiceImpl();

    // UC6: Create Address Book
    public void createAddressBook(String name) {
        service.createAddressBook(name);
    }

    // UC6: Get all Address Books
    public Map<String, AddressBook> getAllAddressBooks() {
        return service.getAllAddressBooks();
    }

    // UC1, UC2, UC5: Add contact
    public void addContact(String bookName, Contact contact) {
        service.addContact(bookName, contact);
    }

    // UC3: Edit contact
    public boolean editContact(String bookName, String firstName, Contact updated) {
        return service.editContact(bookName, firstName, updated);
    }

    // UC4: Delete contact
    public boolean deleteContact(String bookName, String firstName) {
        return service.deleteContact(bookName, firstName);
    }
}
