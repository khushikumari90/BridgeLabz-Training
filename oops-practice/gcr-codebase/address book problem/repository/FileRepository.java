package com.example.AddressBookProblem.repository;

import com.example.AddressBookProblem.model.Contact;
import java.io.FileWriter;
import java.util.List;

public class FileRepository {

    // UC 12 – File IO
    public void writeToFile(List<Contact> contacts) {
        try (FileWriter fw = new FileWriter("addressbook.txt")) {
            for (Contact c : contacts) {
                fw.write(c.toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
