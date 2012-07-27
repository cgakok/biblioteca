package com.twu28.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CollectionTest {

    @Test
    public void listAllBooksInCollection() {
        //Given
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings.");
        books.add("A Storm of Swords.");
        Collection collection = new Collection(books);
        //When
        ArrayList<String> booksInCollection = collection.listAllBooks();
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
        Collection collection = new Collection(books);
        //When
        boolean bookInList = collection.checkBookIsInList("A Clash of Kings");
        //Then
        assertThat(bookInList, is(true));
    }

    @Test
    public void makeReservation() {
        //Given
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings.");
        books.add("A Storm of Swords.");
        Collection collection = new Collection(books);
        String toBeReserved = "A Clash of Kings.";
        //When
        String reservation = collection.makeReservation(toBeReserved);
        //Then
        assertThat(reservation, is("Thank You! Enjoy the book."));
    }

}
