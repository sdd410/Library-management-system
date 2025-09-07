package service;

import entity.Patron;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public class PatronService {

    private final Map<Integer, Patron> patrons = new HashMap<>();
    int patronId = 1;

    public Patron addPatron(String name, String contact) {
        Patron patron = new Patron(patronId++, name, contact);
        patrons.put(patron.getId(), patron);
        System.out.println(name + "added successfully to the Patron list");
        return patron;
    }

    public void updatePatron(int id, String newName, String newContact) {
        if (patrons.containsKey(id)) {
            Patron patron = patrons.get(id);
            if (nonNull(newName)) {
                patron.setName(newName);
            }
            if (nonNull(newContact)) {
                patron.setContact(newContact);
            }
            System.out.println("Patron updated  with name : " + patron.getName());
        } else {
            System.out.println("Patron not found with ID: " + id);
        }
    }

    public Patron getPatronById(int id) {
        return patrons.get(id);
    }

    public Collection<Patron> getAllPatrons() {
        return patrons.values();
    }

    public void showBorrowingHistory(int id) {
        Patron patron = patrons.get(id);
        if (patron != null) {
            patron.getBooksBorrowed().forEach(System.out::println);
        } else {
            System.out.println("Patron not found with ID: " + id);
        }
    }
}
