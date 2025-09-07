package entity;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    private Integer id;
    private String name;
    private String contact;
    private final List<BorrowRecord> booksBorrowed;

    public Patron(Integer id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.booksBorrowed = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<BorrowRecord> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void addBookBorrowed(BorrowRecord book) {
        this.booksBorrowed.add(book);
    }

    @Override
    public String toString() {
        return "Patron " + id + ": " + name;
    }
}
