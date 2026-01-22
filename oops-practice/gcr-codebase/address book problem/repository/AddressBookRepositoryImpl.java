package repository;

import model.Contact;
import java.util.ArrayList;
import java.util.List;

public class AddressBookRepositoryImpl implements AddressBookRepository {

    private final List<Contact> contactList = new ArrayList<>();

    @Override
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }
}
