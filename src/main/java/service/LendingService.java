package service;

import entity.Book;
import entity.BorrowRecord;
import entity.LibraryBranch;
import entity.Patron;

import java.time.LocalDate;

public class LendingService {

    private final InventoryService inventoryService = new InventoryService();

    public void checkoutBook(Patron patron, Book book, LibraryBranch branch) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            inventoryService.removeBookFromBranch(branch, book.getIsbn());
            patron.addBookBorrowed(new BorrowRecord(book, LocalDate.now()));
            System.out.println(patron + " checked out " + book);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Patron patron, Book book, LibraryBranch libraryBranch) {
        if (patron.getBooksBorrowed().isEmpty()) {
            System.out.println("There is not book recorded with the Patron.");
        }
        for (BorrowRecord borrowRecord : patron.getBooksBorrowed()) {
            if (borrowRecord.getBook().getIsbn().equalsIgnoreCase(book.getIsbn()) && !book.isAvailable()) {
                borrowRecord.setReturnDate(LocalDate.now());
                book.setAvailable(true);
                inventoryService.addBookToBranch(libraryBranch, book);
                System.out.println(patron + " returned book " + book);
                return;
            }
        }
        System.out.println("No matching borrow record found.");
    }
}
