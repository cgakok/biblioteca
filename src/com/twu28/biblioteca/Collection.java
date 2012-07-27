package com.twu28.biblioteca;

import java.util.ArrayList;

public class Collection {

    private ArrayList<String> books;

    public Collection(ArrayList<String> books) {
        this.books = books;
    }

    public ArrayList<String> listAllBooks() {
        return books;
    }

    public boolean checkBookIsInList(String book) {
        if (!books.contains(book)) return false;
        else return true;
    }

    public String makeReservation(String toBeReserved) {
        if (!books.contains(toBeReserved)) return "Sorry we don't have that book yet.";
        else return "Thank You! Enjoy the book.";
    }
}
