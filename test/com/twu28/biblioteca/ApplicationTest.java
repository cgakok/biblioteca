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


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldShowAWelcomeMessageWenApplicationStarts(){

        Display display = new FakeTestDisplay();
        Application application = new Application(display);

        application.showWelcomeMessage();

        String firstline = display.getContent().trim();
        assertThat(firstline, is("Welcome to biblioteca!"));
    }
}
