package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// UC2: AddressBook HAS-A relationship with Contact
public class AddressBook {

    // UC5: Use Collection to store multiple contacts
    private final List<Contact> contacts = new ArrayList<>();

    // UC2 / UC5: Add contact to Address Book
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // UC3 / UC4: Find contact using first name
    public Contact findByFirstName(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }
        return null;
    }

    // UC3: Edit existing contact using name
    public boolean editContact(String firstName, Contact updated) {
        Contact existing = findByFirstName(firstName);
        if (existing != null) {
            existing.update(updated);
            return true;
        }
        return false;
    }

    // UC4: Delete person using name
    public boolean deleteContact(String firstName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getFirstName().equalsIgnoreCase(firstName)) {
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
