package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private Collection books;
    private Display display;
    private boolean quit;

    public Menu(Collection books, Display display) {
        this.books = books;
        this.display = display;
    }


    public void cycleThroughMenu(Collection collection) throws IOException {
        while (quit == false) {
            display.println("Please select from the following options: ");
            String input = display.read();
//            this.select(input, collection);
        }
    }

    public void reserve() throws IOException {
        display.println("Which book would you like to reserve?");
        String input = display.read();
        display.println(books.makeReservation(input));
    }

    public void retrieve() {
        display.println("Please talk to Librarian. Thank you.");
    }

    public void exit() {
        quit = true;
        display.println("Bye bye!");
    }

    public void viewBooks() {
        ArrayList<String> booksInLibrary = books.listAllBooks();
        for (String book : booksInLibrary) {
            display.println(book);
        }
    }
}
