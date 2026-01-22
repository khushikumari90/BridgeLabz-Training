package service;

import model.AddressBook;
import model.Contact;
import repository.AddressBookRepository;
import repository.AddressBookRepositoryImpl;

import java.util.Map;

// Service implementation
public class AddressBookServiceImpl
        implements AddressBookService {

    private final AddressBookRepository repository =
            new AddressBookRepositoryImpl();

    @Override
    public void createAddressBook(String name) {
        repository.createAddressBook(name);
    }

    @Override
    public Map<String, AddressBook> getAllAddressBooks() {
        return repository.getAllAddressBooks();
    }

    @Override
    public void addContact(String bookName, Contact contact) {
        repository.addContact(bookName, contact);
    }

    @Override
    public boolean editContact(String bookName, String firstName, Contact updated) {
        return repository.editContact(bookName, firstName, updated);
    }

    @Override
    public boolean deleteContact(String bookName, String firstName) {
        return repository.deleteContact(bookName, firstName);
    }
}
