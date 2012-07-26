package com.twu28.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldShowAWelcomeMessageWhenApplicationStarts() {

        Display display = new FakeTestDisplay();
        Application application = new Application(display);

        application.showWelcomeMessage();

        String firstline = display.getContent().trim();
        assertThat(firstline, is("Welcome to biblioteca!"));
    }

    @Test
    public void createMenu() {

        Application application = new Application(new FakeTestDisplay());

        Menu menu = application.createMenu();

        assertThat(menu.listMenuOptions().size(), is(4));
    }

    @Test
    public void createCollection() {
        Application application = new Application(new Display());

        Collection collection = application.createCollection();

        assertThat(collection.listAllBooks().size(), is(3));

    }


}
