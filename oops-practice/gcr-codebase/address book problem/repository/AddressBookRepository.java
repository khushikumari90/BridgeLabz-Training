package com.example.AddressBookProblem.repository;

import com.example.AddressBookProblem.model.Contact;
import java.util.*;

public class AddressBookRepository {

    // UC 4 – Collection to store contacts
    private List<Contact> contacts = new ArrayList<>();

    // UC 6 – Add Contact with duplicate check
    public void add(Contact contact) {
        if (contacts.contains(contact))
            throw new RuntimeException("Duplicate Contact Found");
        contacts.add(contact);
    }

    // UC 2 – Edit Contact
    public void edit(String firstName, Contact newContact) {
        delete(firstName);
        add(newContact);
    }

    // UC 3 – Delete Contact
    public void delete(String firstName) {
        contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
    }

    public List<Contact> getAll() {
        return contacts;
    }
}
