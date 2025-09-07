package service;

import entity.LibraryBranch;

import java.util.HashMap;
import java.util.Map;

public class LibraryBranchService {

    private final Map<Integer, LibraryBranch> libraryBranches = new HashMap<>();
    private int branchId = 1;

    public LibraryBranch addLibraryBranch(String name) {
        LibraryBranch libraryBranch = new LibraryBranch(branchId++, name);
        libraryBranches.put(libraryBranch.getBranchId(), libraryBranch);
        System.out.println("Library Branch added successfully, with branch name : " + name);
        return libraryBranch;
    }

    public void getLibraryBranch(Integer id) {
        System.out.println(libraryBranches.get(id));
    }

    public void findBookByTitle(String title) {
        libraryBranches.values().stream()
                .flatMap(libraryBranch -> libraryBranch.getBooks().values().stream())
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Book with title " + title + " NOT FOUND!"));
    }

    public void findBookByAuthor(String author) {
        libraryBranches.values().stream()
                .flatMap(libraryBranch -> libraryBranch.getBooks().values().stream())
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList()
                .forEach(System.out::println);
    }

}

