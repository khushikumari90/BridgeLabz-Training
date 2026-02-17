package com.example.AddressBookProblem.main;

import com.example.AddressBookProblem.controller.AddressBookController;
import com.example.AddressBookProblem.model.Contact;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBookController controller = new AddressBookController();

        controller.add(new Contact(
                "Khushi", "Kumari",
                "Agra", "Agra", "UP",
                "283122", "9876543210",
                "khushi@gmail.com"));

        controller.saveAll();
    }
}
