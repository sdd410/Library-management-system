package controller;

import entity.LibraryBranch;
import service.LibraryBranchService;

public class LibraryBranchController {

    private final LibraryBranchService libraryBranchService = new LibraryBranchService();

    public LibraryBranch addLibraryBranch(String name) {
        return libraryBranchService.addLibraryBranch(name);
    }

    public void findBookByTitle(String name) {
        libraryBranchService.findBookByTitle(name);
    }

    public void findBookByAuthor(String name) {
        libraryBranchService.findBookByAuthor(name);
    }

    public void getLibraryBranch(int id) {
        libraryBranchService.getLibraryBranch(id);
    }
}
