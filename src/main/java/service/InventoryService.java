package service;

import entity.Book;
import entity.LibraryBranch;

import static java.util.Objects.nonNull;

public class InventoryService {

    public void addBookToBranch(LibraryBranch branch, Book book) {
        branch.getBooks().put(book.getIsbn(), book);
        System.out.println("Book added to branch : " + branch.getName() + " with isbn : " + book.getIsbn());
    }

    public void removeBookFromBranch(LibraryBranch branch, String isbn) {
        branch.getBooks().remove(isbn);
        System.out.println("Book removed from branch : " + branch.getName() + " with isbn : " + isbn);
    }

    public void updateBook(LibraryBranch branch, String isbn, String title, String author, String year) {
        if (branch.getBooks().containsKey(isbn)) {
            Book book = branch.getBooks().get(isbn);
            if (nonNull(title)) {
                book.setTitle(title);
            }
            if (nonNull(author)) {
                book.setAuthor(author);
            }
            if (nonNull(year)) {
                book.setPublicationYear(year);
            }
            System.out.println("Book successfully updated with isbn id : " + isbn);
        } else {
            System.out.println("Book not available in the Branch!");
        }
    }

    public void showAllActiveBooks(LibraryBranch branch) {
        branch.getBooks().values().forEach(System.out::println);
    }
}
