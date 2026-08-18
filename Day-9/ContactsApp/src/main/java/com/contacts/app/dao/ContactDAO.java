package com.contacts.app.dao;

import com.contacts.app.entity.Contact;

import java.util.List;
import java.util.Optional;

/**
 * DEMO interface for Spring bean resolution exercise (@Primary vs @Qualifier).
 * Not wired into the real ContactService/ContactRepository CRUD flow.
 */
public interface ContactDAO {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    Contact save(Contact contact);
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByEmail(String email);
}