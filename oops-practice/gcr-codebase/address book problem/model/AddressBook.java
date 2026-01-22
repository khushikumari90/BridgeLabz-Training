package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {

    private final List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact findContactByFirstName(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }
        return null;
    }

    public boolean deleteContactByFirstName(String firstName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
