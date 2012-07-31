package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    FakeTestDisplay display;
    Application application;
    Menu menu;
    BookCollection bookCollection;

    @Before
    public void setUp() throws Exception {
        display = new FakeTestDisplay();
        application = new Application(display);
        bookCollection = application.createCollection();
        menu = application.createMenu();
    }

    @Test
    public void whenUserSelectsViewSelectAllBooks() throws IOException {
        //When
        menu.viewBooks();
        //Then
        assertThat(display.getContent(), is("A Game of Thrones\nA Clash of Kings\nA Storm of Swords"));

    }

    @Test
    public void whenUserSelectsRetrieveSeeLibraryNumber() throws IOException {
        //When
        menu.retrieve();
        //Then
        assertThat(display.getContent(), is("Please talk to Librarian. Thank you."));
    }

    @Test
    public void whenUserSelectsReserveAndBooksInCollectionReserve() throws IOException {
        //When
        display.setInput("A Clash of Kings");
        menu.reserve();
        //Then
        assertThat(display.getContent(), is("Which book would you like to reserve?\nThank You! Enjoy the book."));

    }

    @Test
    public void checkThatQuitHasBeenSwitchedOn() {
        //Given
        menu.exit();
        //When
        boolean quit = menu.quitCommandEntered();
        //Then
        assertThat(quit, is(true));
    }
}
