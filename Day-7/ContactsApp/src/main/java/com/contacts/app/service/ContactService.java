    package com.contacts.app.service;

    import com.contacts.app.dto.ContactRequestDTO;
    import com.contacts.app.dto.ContactResponseDTO;
    import com.contacts.app.entity.Contact;

    import java.util.List;

    public interface ContactService {
        List<ContactResponseDTO> getAllContacts();

        ContactResponseDTO getContactById(Long id);

        ContactResponseDTO createContact(ContactRequestDTO requestDTO);

        ContactResponseDTO updateContact(Long id,ContactRequestDTO requestDTO);

        void deleteContact(Long id);
    }
