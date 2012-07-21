package com.twu28.biblioteca;

import java.util.ArrayList;
import org.junit.Test;

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
        Menu menu = new Menu(menuOptions);
        //When
        ArrayList<String> options = menu.listMenuOptions();
        //Then
        assertThat(options.contains("Reserve"), is(true));
        assertThat(options.size(), is(4));
    }
}
