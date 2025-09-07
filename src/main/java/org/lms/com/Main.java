package org.lms.com;

import controller.InventoryServiceController;
import controller.LendingController;
import controller.LibraryBranchController;
import controller.PatronController;
import entity.Book;
import entity.LibraryBranch;
import entity.Patron;

public class Main {

    public static void main(String[] args) {

        // ----------------------- ADD LIBRARY BRANCHES -----------------------
        LibraryBranchController libraryBranchController = new LibraryBranchController();
        LibraryBranch libraryBranchFiction = libraryBranchController.addLibraryBranch("Fiction");
        LibraryBranch libraryBranchMind = libraryBranchController.addLibraryBranch("Mind");

        // ----------------------- CREATE BOOKS -----------------------
        Book bookFiction1 = new Book("9780743273565", "The Great Gatsby", "F. Scott Fitzgerald", "1925");
        Book bookFiction2 = new Book("9780439139601", "Harry Potter and the Goblet of Fire", "J.K. Rowling", "2000");
        Book bookFiction3 = new Book("9780316769488", "The Catcher in the Rye", "J.D. Salinger", "1951");
        Book bookFiction4 = new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee", "1960");

        Book bookMind1 = new Book("9780374533557", "Thinking, Fast and Slow", "Daniel Kahneman", "2011");
        Book bookMind2 = new Book("9780141033570", "The Power of Habit", "Charles Duhigg", "2012");
        Book bookMind3 = new Book("9780062316097", "Quiet: The Power of Introverts in a World That Can't Stop Talking", "Susan Cain", "2012");
        Book bookMind4 = new Book("9781847941831", "Mindset: The New Psychology of Success", "Carol S. Dweck", "2006");

        // ----------------------- ADD BOOKS TO BRANCHES -----------------------
        System.out.println("----------------------- ADD BOOK TO BRANCH -----------------------");
        InventoryServiceController inventoryServiceController = new InventoryServiceController();

        inventoryServiceController.addBookToBranch(libraryBranchFiction, bookFiction1);
        inventoryServiceController.addBookToBranch(libraryBranchFiction, bookFiction2);
        inventoryServiceController.addBookToBranch(libraryBranchFiction, bookFiction3);
        inventoryServiceController.addBookToBranch(libraryBranchFiction, bookFiction4);

        inventoryServiceController.addBookToBranch(libraryBranchMind, bookMind1);
        inventoryServiceController.addBookToBranch(libraryBranchMind, bookMind2);
        inventoryServiceController.addBookToBranch(libraryBranchMind, bookMind3);
        inventoryServiceController.addBookToBranch(libraryBranchMind, bookMind4);

        // ----------------------- REMOVE BOOK FROM BRANCH -----------------------
        System.out.println("----------------------- REMOVE BOOK FROM BRANCH -----------------------");
        inventoryServiceController.removeBookFromBranch(libraryBranchFiction, bookFiction4.getIsbn());
        inventoryServiceController.removeBookFromBranch(libraryBranchMind, bookMind4.getIsbn());

        // ----------------------- UPDATE BOOK DETAILS -----------------------
        System.out.println("----------------------- UPDATE BOOK DETAILS -----------------------");
        inventoryServiceController.updateBook(
                libraryBranchFiction,
                bookFiction1.getIsbn(),
                "The Great Gatsby and the girl",
                null,
                null
        );

        // ----------------------- SEARCH BOOK -----------------------
        System.out.println("----------------------- SEARCH BOOK BY TITLE, AUTHOR NAME -----------------------");
        libraryBranchController.findBookByTitle("The Great Gatsby and the girl");
        libraryBranchController.findBookByAuthor("Daniel Kahneman");

        // ----------------------- PATRON FUNCTIONALITIES -----------------------
        System.out.println("----------------------- PATRON FUNCTIONALITIES -----------------------");
        PatronController patronController = new PatronController();

        Patron sidhartPatron = patronController.addPatron("Sidharth", "sidharthsmsd@gmail.com");
        Patron sophiyaPatron = patronController.addPatron("Sophiya", "sophiya@gmail.com");

        // ----------------------- UPDATE PATRON -----------------------
        System.out.println("----------------------- UPDATE PATRON -----------------------");
        patronController.updatePatron(sidhartPatron.getId(), "Rohan", "rohan@gmail.com");

        // ----------------------- LENDING PROCESS -----------------------
        System.out.println("----------------------- LENDING PROCESS -----------------------");
        LendingController lendingController = new LendingController();

        // Sidharth checks out a book
        lendingController.checkoutBook(bookFiction1, sidhartPatron, libraryBranchFiction);

        // Sophiya tries for the same book -> should display "not available"
        lendingController.checkoutBook(bookFiction1, sophiyaPatron, libraryBranchFiction);

        // Show borrowing record of Sidharth
        patronController.showBorrowingHistory(sidhartPatron.getId());

        // Show all available books
        inventoryServiceController.showAllActiveBooks(libraryBranchFiction);

        // Sidharth returns the book
        lendingController.returnBook(bookFiction1, sidhartPatron, libraryBranchFiction);

        // Show borrowing record of Sidharth
        patronController.showBorrowingHistory(sidhartPatron.getId());

        // Sophiya checks out the same book
        lendingController.checkoutBook(bookFiction1, sophiyaPatron, libraryBranchFiction);

        // Show borrowing record of Sophiya
        patronController.showBorrowingHistory(sophiyaPatron);
    }
}
