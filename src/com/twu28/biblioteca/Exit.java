package com.twu28.biblioteca;

import java.io.IOException;

public class Exit implements MenuOption {
    private Menu menu;

    public Exit(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.exit();
    }
}
