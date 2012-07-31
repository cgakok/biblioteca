package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private BookCollection books;
    private Display display;
    private boolean quit;

    public Menu(BookCollection books, Display display) {
        this.books = books;
        this.display = display;
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
    }

    public void viewBooks() {
        ArrayList<String> booksInLibrary = books.listAllBooks();
        for (String book : booksInLibrary) {
            display.println(book);
        }
    }

    public boolean quitCommandEntered() {
        return quit;
    }
}
