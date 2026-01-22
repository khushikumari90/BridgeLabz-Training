package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// UC2: AddressBook HAS-A Contact
public class AddressBook {

    // UC5: Collection to store multiple contacts
    private final List<Contact> contacts = new ArrayList<>();

    // ✅ UC7: Add contact with duplicate check
    public boolean addContact(Contact contact) {

        // Collection method uses equals()
        if (contacts.contains(contact)) {
            System.out.println("Duplicate contact found. Not added.");
            return false;
        }

        contacts.add(contact);
        return true;
    }

    // UC3 / UC4
    public Contact findByFirstName(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }
        return null;
    }

    // UC3
    public boolean editContact(String firstName, Contact updated) {
        Contact existing = findByFirstName(firstName);
        if (existing != null) {
            existing.update(updated);
            return true;
        }
        return false;
    }

    // UC4
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
