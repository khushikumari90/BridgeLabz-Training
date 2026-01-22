package service;

import model.Contact;
import repository.AddressBookRepository;
import repository.AddressBookRepositoryImpl;

public class AddressBookServiceImpl
        implements AddressBookService {

    private final AddressBookRepository repository =
            new AddressBookRepositoryImpl();

    @Override
    public void addContact(Contact contact) {
        repository.addContact(contact);
    }

    @Override
    public void addContactUsingAddressBook(Contact contact) {
        repository.addContactUsingAddressBook(contact);
    }

    @Override
    public boolean editContactByName(String firstName, Contact updatedContact) {
        return repository.editContactByName(firstName, updatedContact);
    }
}
