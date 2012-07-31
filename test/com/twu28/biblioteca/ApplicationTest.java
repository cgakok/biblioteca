package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationTest {
    FakeTestDisplay display;
    Application application;

    @Before
    public void setUp() throws Exception {
        display = new FakeTestDisplay();
        application = new Application(display);
    }

    @Test
    public void shouldShowAWelcomeMessageWhenApplicationStarts() {
        application.showWelcomeMessage();
        String firstline = display.getContent().trim();
        assertThat(firstline, is("Welcome to biblioteca!"));
    }

    @Test
    public void createCollection() {
        BookCollection bookCollection = application.createCollection();
        assertThat(bookCollection.listAllBooks().size(), is(3));
    }

    @Test
    public void runApplication() throws IOException {
        //Given
        Menu menu = application.createMenu();
        //When
        display.setInput("quit");
        application.RunMenu();

        //Then
        assertThat(display.getContent(), is("Please select an option: [retrieve, reserve, view, quit]\nBye bye!"));
    }
}
