package entity;

import java.util.HashMap;
import java.util.Map;

public class LibraryBranch {

    private int branchId;
    private String name;
    private final Map<String, Book> books;

    public LibraryBranch(int branchId, String name) {
        this.branchId = branchId;
        this.name = name;
        this.books = new HashMap<>();
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "LibraryBranch{" +
                "branchId=" + branchId +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
