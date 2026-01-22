package repository;

import model.Contact;

public interface AddressBookRepository {

    // UC1
    void addContact(Contact contact);

    // UC2
    void addContactUsingAddressBook(Contact contact);
}
