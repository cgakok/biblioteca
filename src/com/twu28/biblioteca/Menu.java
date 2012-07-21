package com.twu28.biblioteca;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuOptions;

    public Menu(ArrayList<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public ArrayList<String> listMenuOptions() {
        return menuOptions;
    }
}
