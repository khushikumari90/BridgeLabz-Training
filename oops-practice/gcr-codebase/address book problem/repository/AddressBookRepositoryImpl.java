package repository;

import model.AddressBook;
import model.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBookRepositoryImpl
        implements AddressBookRepository {

    // UC1 storage
    private final List<Contact> contactList = new ArrayList<>();

    // UC2 + UC3 storage
    private final AddressBook addressBook = new AddressBook();

    // UC1
    @Override
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully (UC1).");
    }

    // UC2
    @Override
    public void addContactUsingAddressBook(Contact contact) {
        addressBook.addContact(contact);
        System.out.println("Contact added using AddressBook (UC2).");
    }

    // UC3
    @Override
    public boolean editContactByName(String firstName, Contact updatedContact) {

        Contact existingContact =
                addressBook.findContactByFirstName(firstName);

        if (existingContact != null) {
            existingContact.setLastName(updatedContact.getFirstName());
            existingContact.setAddress(updatedContact.toString());
            existingContact.setCity(updatedContact.toString());
            existingContact.setState(updatedContact.toString());
            existingContact.setZip(updatedContact.toString());
            existingContact.setPhoneNumber(updatedContact.toString());
            existingContact.setEmail(updatedContact.toString());
            return true;
        }
        return false;
    }
}
