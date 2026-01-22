package service;

import model.Contact;
import repository.AddressBookRepository;
import repository.AddressBookRepositoryImpl;

public class AddressBookServiceImpl
        implements AddressBookService {

    private final AddressBookRepository repository =
            new AddressBookRepositoryImpl();

    // UC1
    @Override
    public void addContact(Contact contact) {
        repository.addContact(contact);
    }

    // UC2
    @Override
    public void addContactUsingAddressBook(Contact contact) {
        repository.addContactUsingAddressBook(contact);
    }
}
