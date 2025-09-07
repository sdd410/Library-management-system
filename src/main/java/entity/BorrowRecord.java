package entity;

import java.time.LocalDate;

public class BorrowRecord {

    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(Book book, LocalDate borrowDate) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
