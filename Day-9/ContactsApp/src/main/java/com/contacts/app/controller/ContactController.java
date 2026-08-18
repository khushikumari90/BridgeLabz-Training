package com.contacts.app.controller;

import com.contacts.app.dto.ContactRequestDTO;
import com.contacts.app.dto.ContactResponseDTO;
import com.contacts.app.service.ContactService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Tag — groups your endpoints under a readable heading
@Tag(name = "Contacts", description = "CRUD operations for managing contacts")
@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/search")
    public ResponseEntity<List<ContactResponseDTO>> searchContacts(@RequestParam String name){
        return ResponseEntity.ok(contactService.searchContactsByName(name));
    }

    //@Parameter — documents individual query/path parameters (useful for your new pagination params)
    @GetMapping
    public ResponseEntity<Page<ContactResponseDTO>> getAllContacts(
            @Parameter(description = "Page number, zero-indexed")   @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of contacts per page") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Field to sort by")            @RequestParam(defaultValue = "id") String sortBy,
            @Parameter(description = "asc or desc")                 @RequestParam(defaultValue = "asc") String direction
    ){
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);
        return ResponseEntity.ok(contactService.getAllContacts(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id){
        return ResponseEntity.ok(contactService.getContactById(id));  //.ok() ?
    }

    //@Operation — describes what a specific endpoint does
    //@ApiResponses — documents possible response codes explicitly
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contact created successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed"),
            @ApiResponse(responseCode = "409", description = "Email already exists")
    })
    @Operation(summary = "Create a new contacts", description = "Validates and persists a new contact. Fails with 400 if validation fails or 409 if email already exists.")
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
