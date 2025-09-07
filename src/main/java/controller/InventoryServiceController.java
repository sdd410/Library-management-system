package controller;

import entity.Book;
import entity.LibraryBranch;
import service.InventoryService;

public class InventoryServiceController {

    private final InventoryService inventoryService = new InventoryService();

    public void addBookToBranch(LibraryBranch libraryBranch, Book book) {
        inventoryService.addBookToBranch(libraryBranch, book);
    }

    public void removeBookFromBranch(LibraryBranch branch, String isbn) {
        inventoryService.removeBookFromBranch(branch, isbn);
    }

    public void updateBook(LibraryBranch branch, String isbn, String title, String author, String year) {
        inventoryService.updateBook(branch, isbn, title, author, year);
    }

    public void showAllActiveBooks(LibraryBranch branch) {
        inventoryService.showAllActiveBooks(branch);
    }
}
