package com.example.AddressBookProblem.test;

import com.example.AddressBookProblem.model.Contact;
import com.example.AddressBookProblem.service.AddressBookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookServiceTest {

    @Test
    void testAddContact() {
        AddressBookService service = new AddressBookService();
        Contact c = new Contact("A","B","X","Y","Z","111111","9999999999","a@gmail.com");
        assertDoesNotThrow(() -> service.addContact(c));
    }

    @Test
    void testDuplicateContact() {
        AddressBookService service = new AddressBookService();
        Contact c = new Contact("A","B","X","Y","Z","111111","9999999999","a@gmail.com");
        service.addContact(c);
        assertThrows(RuntimeException.class, () -> service.addContact(c));
    }
}

