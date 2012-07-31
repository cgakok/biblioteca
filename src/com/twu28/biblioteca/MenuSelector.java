package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuSelector {
    private Menu menu;
    private Display display;
    private HashMap<String, Object> menuOptions;

    public MenuSelector(Menu menu, Display display) {
        this.menu = menu;
        this.display = display;
        menuOptions = new HashMap<String, Object>();
        this.addDefaultOptions();
    }

    public void selectOption(String command) throws IOException {
        if (!menuOptions.containsKey(command)) {
            display.println("Please select a valid option!!");
        } else {
            MenuOption selected = (MenuOption) menuOptions.get(command);
            selected.execute();
        }
    }

    public void addDefaultOptions() {
        menuOptions.put("reserve", new Reserve(menu));
        menuOptions.put("retrieve", new Retrieve(menu));
        menuOptions.put("quit", new Exit(menu));
        menuOptions.put("view", new ViewBooks(menu));
    }

    public ArrayList<String> listOptions() {
        return new ArrayList<String>(menuOptions.keySet());
    }
}

