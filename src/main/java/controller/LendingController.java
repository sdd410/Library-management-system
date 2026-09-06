package controller;

import entity.Book;
import entity.LibraryBranch;
import entity.Patron;
import service.LendingService;

public class LendingController {

    private final LendingService lendingService = new LendingService();

    //checkout service
    public void checkoutBook(Book book, Patron patron, LibraryBranch libraryBranch) {
        lendingService.checkoutBook(patron, book, libraryBranch);
    }

    //return service
    public void returnBook(Book book, Patron patron, LibraryBranch branch) {
        lendingService.returnBook(patron, book, branch);
    }

}
