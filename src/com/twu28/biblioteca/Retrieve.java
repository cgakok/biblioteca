package com.twu28.biblioteca;

import java.io.IOException;

public class Retrieve implements MenuOption {
    private Menu menu;

    public Retrieve(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.retrieve();
    }
}
