package com.twu28.biblioteca;

import java.io.IOException;

public class Reserve implements MenuOption {
    private Menu menu;

    public Reserve(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.reserve();
    }
}
