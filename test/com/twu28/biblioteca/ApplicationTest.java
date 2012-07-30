package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

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
        Collection collection = application.createCollection();
        assertThat(collection.listAllBooks().size(), is(3));
    }
}
