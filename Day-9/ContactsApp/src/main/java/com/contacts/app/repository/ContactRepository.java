package com.contacts.app.repository;

import com.contacts.app.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    boolean existsByEmail(String email);
    List<Contact> findByNameContainingIgnoreCase(String name);
}
