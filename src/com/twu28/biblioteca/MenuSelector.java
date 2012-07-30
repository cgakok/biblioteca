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
    }


    public void selectOption(String command) throws IOException {

        if (!menuOptions.containsKey(command)) {
            display.println("Please select a valid option!!");
        }
        else {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuSelector that = (MenuSelector) o;
        if (display != null ? !display.equals(that.display) : that.display != null) return false;
        if (menu != null ? !menu.equals(that.menu) : that.menu != null) return false;
        if (menuOptions != null ? !menuOptions.equals(that.menuOptions) : that.menuOptions != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = menu != null ? menu.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (menuOptions != null ? menuOptions.hashCode() : 0);
        return result;
    }
}

