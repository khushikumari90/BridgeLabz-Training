package com.contacts.app.service;

import com.contacts.app.dto.ContactRequestDTO;
import com.contacts.app.dto.ContactResponseDTO;
import com.contacts.app.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {
    List<ContactResponseDTO> searchContactsByName(String name);
    Page<ContactResponseDTO> getAllContacts(Pageable pageable);

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO createContact(ContactRequestDTO requestDTO);

    ContactResponseDTO updateContact(Long id,ContactRequestDTO requestDTO);

    void deleteContact(Long id);
}
