package com.twu28.biblioteca;

import java.io.IOException;

public class ViewBooks implements MenuOption {
    private Menu menu;

    public ViewBooks(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.viewBooks();
    }
}
