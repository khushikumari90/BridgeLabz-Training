package main;

import controller.AddressBookController;

public class Main {

    public static void main(String[] args) {
        AddressBookController controller =
                new AddressBookController();
        controller.createContact();
    }
}

