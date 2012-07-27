package com.twu28.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    @Test
    public void listMenuOptions() {
        //Given
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("View");
        menuOptions.add("Reserve");
        menuOptions.add("Retrieve");
        menuOptions.add("Quit");
        Menu menu = new Menu(menuOptions, new FakeTestDisplay());
        //When
        ArrayList<String> options = menu.listMenuOptions();
        //Then
        assertThat(options.contains("Reserve"), is(true));
        assertThat(options.size(), is(4));

    }

    @Test
    public void whenUserSelectsViewSelectAllBooks() throws IOException {
        //Given
        Display display = new FakeTestDisplay();
        Application application = new Application(display);
        Menu menu = application.createMenu();
        Collection collection = application.createCollection();
        //When
        menu.select("view", collection, "");
        //
        assertThat(display.getContent(), is("A Game of Thrones\nA Clash of Kings\nA Storm of Swords"));

    }

    @Test
    public void whenUserSelectsRetrieveSeeLibraryNumber() throws IOException {
        //Given
        Display display = new FakeTestDisplay();
        Application application = new Application(display);
        Menu menu = application.createMenu();
        Collection collection = application.createCollection();
        //When
        menu.select("retrieve", collection, "");
        //Then
        assertThat(display.getContent(), is("Please talk to Librarian. Thank you."));
    }

    @Test
    public void whenUserSelectsReserveAndBooksInCollectionReserve() throws IOException {
        //Given
        Display display = new FakeTestDisplay();
        Application application = new Application(display);
        Menu menu = application.createMenu();
        Collection collection = application.createCollection();
        //When
        menu.select("reserve", collection, "A Clash of Kings");
        //Then
        assertThat(display.getContent(), is("Thank You! Enjoy the book."));

    }

    @Test
    public void checkThatInvalidOptionReturnsMessage() throws IOException {
        //Given
        Display display = new FakeTestDisplay();
        Application application = new Application(display);
        Menu menu = application.createMenu();
        Collection collection = application.createCollection();
        //When
        menu.select("thisIsNotAValidOption", collection, "");
        //Then
        assertThat(display.getContent(), is("Select a valid option!!"));
    }

    @Test
    public void checkThatSelectingQuitDisplaysAMessage() throws IOException {
        //Given
        Display display = new FakeTestDisplay();
        Application application = new Application(display);
        Menu menu = application.createMenu();
        Collection collection = application.createCollection();
        //When
        menu.select("quit", collection, "");
        //Then
        assertThat(display.getContent(), is("Bye bye!"));

    }
}
