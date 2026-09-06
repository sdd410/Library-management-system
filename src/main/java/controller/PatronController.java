package controller;

import entity.Patron;
import service.PatronService;

public class PatronController {

    private final PatronService patronService = new PatronService();

    public Patron addPatron(String name, String contact) {
        return patronService.addPatron(name, contact);
    }

    public void updatePatron(int id, String name, String contact) {
        patronService.updatePatron(id, name, contact);
    }

    public void getPatronById(int id) {
        System.out.println(patronService.getPatronById(id));
    }

    public void getAllPatrons() {
        patronService.getAllPatrons().forEach(System.out::println);
    }

    public void showBorrowingHistory(int id) {
        patronService.showBorrowingHistory(id);
    }

    public void showBorrowingHistory(Patron patron) {
        patronService.showBorrowingHistory(patron.getId());
    }
}
