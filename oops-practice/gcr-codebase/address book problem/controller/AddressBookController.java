package com.example.AddressBookProblem.controller;

import com.example.AddressBookProblem.model.Contact;
import com.example.AddressBookProblem.service.AddressBookService;

public class AddressBookController {

    private AddressBookService service = new AddressBookService();

    public void add(Contact c) {
        service.addContact(c);
    }

    public void saveAll() {
        service.saveAllAsync();
    }
}
