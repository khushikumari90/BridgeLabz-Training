package com.contacts.app.controller;

import com.contacts.app.dto.ContactRequestDTO;
import com.contacts.app.dto.ContactResponseDTO;
import com.contacts.app.service.ContactService;

import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id){
        return ResponseEntity.ok(contactService.getContactById(id));  //.ok() ?
    }

    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(@Valid @RequestBody ContactRequestDTO requestDTO){
        ContactResponseDTO response = contactService.createContact(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable Long id,
                                                            @Valid @RequestBody ContactRequestDTO requestDTO){
        ContactResponseDTO response = contactService.updateContact(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();  //.noContent().build()
    }
}
