package com.contacts.app.mapper;

import com.contacts.app.dto.ContactRequestDTO;
import com.contacts.app.dto.ContactResponseDTO;
import com.contacts.app.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    //Request DTO -> Entity
    public Contact toEntity(ContactRequestDTO requestDTO){

        Contact contact = new Contact();
        contact.setName(requestDTO.getName());
        contact.setPhone(requestDTO.getPhone());
        contact.setEmail(requestDTO.getEmail());
        return contact;
    }

    //Entity -> Reponse DTO
    public ContactResponseDTO toResponseDTO(Contact contact) {
        return new ContactResponseDTO(contact.getId(), contact.getName(), contact.getPhone(), contact.getEmail());
    }

}
