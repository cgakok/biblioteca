package com.twu28.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookCollectionTest {
    @Test
    public void listAllBooksInCollection() {
        //Given
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings.");
        books.add("A Storm of Swords.");
        BookCollection bookCollection = new BookCollection(books);
        //When
        ArrayList<String> booksInCollection = bookCollection.listAllBooks();
        //Then
        assertThat(booksInCollection.size(), is(3));
    }

    @Test
    public void checkThatBookIsInList() {
        //Given
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings");
        books.add("A Storm of Swords");
        BookCollection bookCollection = new BookCollection(books);
        //When
        boolean bookInList = bookCollection.checkBookIsInList("A Clash of Kings");
        //Then
        assertThat(bookInList, is(true));
    }

    @Test
    public void makeReservation() {
        //Given
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings");
        books.add("A Storm of Swords");
        BookCollection bookCollection = new BookCollection(books);
        String toBeReserved = "A Clash of Kings";
        //When
        String reservation = bookCollection.makeReservation(toBeReserved);
        //Then
        assertThat(reservation, is("Thank You! Enjoy the book."));
    }

}
