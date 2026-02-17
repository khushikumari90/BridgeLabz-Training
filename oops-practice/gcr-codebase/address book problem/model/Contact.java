package com.example.AddressBookProblem.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    // UC 1 – Create Contact
    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phone, String email) {

        validate(phone, email);

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    // UC 7 – Regex Validation
    private void validate(String phone, String email) {
        if (!Pattern.matches("\\d{10}", phone))
            throw new IllegalArgumentException("Invalid Phone Number");

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email))
            throw new IllegalArgumentException("Invalid Email");
    }

    // UC 7 – Override equals for duplicate check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return firstName.equalsIgnoreCase(contact.firstName)
                && lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    // UC 10 – toString override
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + city + ", " + state + ", " + zip;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}
