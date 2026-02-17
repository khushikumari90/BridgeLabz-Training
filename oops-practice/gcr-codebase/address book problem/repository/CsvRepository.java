package com.example.AddressBookProblem.repository;

import com.example.AddressBookProblem.model.Contact;
import java.io.FileWriter;
import java.util.List;

public class CsvRepository {

    // UC 13 – CSV File
    public void writeCSV(List<Contact> contacts) {
        try (FileWriter fw = new FileWriter("addressbook.csv")) {
            for (Contact c : contacts) {
                fw.write(c.getFirstName() + "," + c.getEmail() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
