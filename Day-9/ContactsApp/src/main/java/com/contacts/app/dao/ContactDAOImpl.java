package com.contacts.app.dao;

import com.contacts.app.entity.Contact;
import com.contacts.app.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class ContactDAOImpl implements ContactDAO {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return contactRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return contactRepository.existsByEmail(email);
    }
}