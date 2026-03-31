package com.example.AddressBookProblem.service;

import com.example.AddressBookProblem.model.Contact;
import com.example.AddressBookProblem.repository.*;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class AddressBookService {

    private AddressBookRepository repo = new AddressBookRepository();
    private FileRepository fileRepo = new FileRepository();
    private CsvRepository csvRepo = new CsvRepository();
    private DatabaseRepository dbRepo = new DatabaseRepository();

    // UC 1,4,6
    public void addContact(Contact c) {
        repo.add(c);
    }

    // UC 10 – Sort by name
    public void sortByName() {
        repo.getAll().sort(Comparator.comparing(Contact::getFirstName));
    }

    // UC 8,9 – View & Count by City
    public Map<String, Long> countByCity() {
        return repo.getAll().stream()
                .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()));
    }

    // UC 17 – Multithreading IO
    public void saveAllAsync() {
        ExecutorService es = Executors.newFixedThreadPool(3);

        es.execute(() -> fileRepo.writeToFile(repo.getAll()));
        es.execute(() -> csvRepo.writeCSV(repo.getAll()));
        es.execute(() -> repo.getAll().forEach(dbRepo::save));

        es.shutdown();
    }
}
