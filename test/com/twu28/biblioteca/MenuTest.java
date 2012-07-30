package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    FakeTestDisplay display;
    Application application;
    Menu menu;
    Collection collection;

    @Before
    public void setUp() throws Exception {
        display = new FakeTestDisplay();
        application = new Application(display);
        menu = application.createMenu();
        collection = application.createCollection();
    }

    @Test
    public void listMenuOptions() {
        //Given
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("View");
        menuOptions.add("Reserve");
        menuOptions.add("Retrieve");
        menuOptions.add("Quit");
        Menu menu = new Menu(menuOptions, display);
        //When
        ArrayList<String> options = menu.listMenuOptions();
        //Then
        assertThat(options.contains("Reserve"), is(true));
        assertThat(options.size(), is(4));

    }

    @Test
    public void whenUserSelectsViewSelectAllBooks() throws IOException {
        //When
        menu.select("view", collection);
        //Then
        assertThat(display.getContent(), is("A Game of Thrones\nA Clash of Kings\nA Storm of Swords"));

    }

    @Test
    public void whenUserSelectsRetrieveSeeLibraryNumber() throws IOException {
        //When
        menu.select("retrieve", collection);
        //Then
        assertThat(display.getContent(), is("Please talk to Librarian. Thank you."));
    }

    @Test
    public void whenUserSelectsReserveAndBooksInCollectionReserve() throws IOException {
        //When
        display.setInput("A Clash of Kings");
        menu.select("reserve", collection);
        //Then
        assertThat(display.getContent(), is("Which book would you like to reserve?\nThank You! Enjoy the book."));

    }

    @Test
    public void checkThatInvalidOptionReturnsMessage() throws IOException {
        //When
        menu.select("thisIsNotAValidOption", collection);
        //Then
        assertThat(display.getContent(), is("Select a valid option!!"));
    }

    @Test
    public void checkThatSelectingQuitDisplaysAMessage() throws IOException {
        //When
        menu.select("quit", collection);
        //Then
        assertThat(display.getContent(), is("Bye bye!"));

    }
}
