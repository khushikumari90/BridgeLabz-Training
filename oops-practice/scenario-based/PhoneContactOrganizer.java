//You are designing a contact organzier for a mobile app.
package oopsscenariobased;
import java.util.*;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

class ContactOrganizer {
    List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }

        for (Contact c : contacts) {
            if (c.phone.equals(phone)) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully");
    }

    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println(c.name + " - " + c.phone);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String phone) {
        contacts.removeIf(c -> c.phone.equals(phone));
        System.out.println("Contact deleted if existed");
    }
}

public class PhoneContactOrganizer {
    public static void main(String[] args) throws Exception {
        ContactOrganizer app = new ContactOrganizer();
        app.addContact("Rahul", "9876543210");
        app.searchContact("Rahul");
        app.deleteContact("9876543210");
    }
}

