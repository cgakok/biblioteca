package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuSelectorTest {
    private FakeTestDisplay display;
    private Application application;
    private BookCollection bookCollection;
    private Menu menu;

    @Before
    public void setUp() {
        display = new FakeTestDisplay();
        application = new Application(display);
        bookCollection = application.createCollection();
        menu = new Menu(bookCollection, display);
    }

    @Test
    public void selectRetrieveAndSeeResponse() throws IOException {
        //Given
        MenuSelector menuSelector = new MenuSelector(menu, display);
        //When
        menuSelector.selectOption("retrieve");
        //Then
        assertThat(display.getContent(), is("Please talk to Librarian. Thank you."));
    }

    @Test
    public void selectInvalidOption() throws IOException {
        //Given
        MenuSelector menuSelector = new MenuSelector(menu, display);
        //When
        menuSelector.selectOption("this is not a valid option!");
        //Then
        assertThat(display.getContent(), is("Please select a valid option!!"));
    }

    @Test
    public void populateSelectorWithOptions() {
        //Given
        MenuSelector menuSelector = new MenuSelector(menu, display);
        //Then
        assertThat(menuSelector.listOptions().size(), is(4));
        assertThat(menuSelector.listOptions().contains("retrieve"), is(true));
    }
}
