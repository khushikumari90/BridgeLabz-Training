package com.contacts.app.dao;

import com.contacts.app.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryContactDAO implements ContactDAO {

    private final List<Contact> contacts = new ArrayList<>(List.of(
            new Contact(1L, "Test User", "9999999999", "test@example.com")
    ));

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contacts.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Contact save(Contact contact) {
        contacts.add(contact);
        return contact;
    }

    @Override
    public void deleteById(Long id) {
        contacts.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        return contacts.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public boolean existsByEmail(String email) {
        return contacts.stream().anyMatch(c -> c.getEmail().equals(email));
    }
}