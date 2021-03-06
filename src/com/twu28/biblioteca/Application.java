package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    private Display display;

    public Application(Display display) {
        this.display = display;
    }

    public static void main(String[] args) throws IOException {
        Application application = new Application(new Display());
        application.showWelcomeMessage();
        application.RunMenu();
    }

    public void showWelcomeMessage() {
        display.println("Welcome to biblioteca!");
    }

    public Menu createMenu() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("view");
        options.add("reserve");
        options.add("retrieve");
        options.add("quit");
        return new Menu(this.createCollection(), display);
    }

    public BookCollection createCollection() {
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings");
        books.add("A Storm of Swords");
        return new BookCollection(books);
    }

    public void RunMenu() throws IOException {
        Menu menu = this.createMenu();
        MenuSelector menuSelector = new MenuSelector(menu, display);
        while (!menu.quitCommandEntered()) {
            display.println("Please select an option: " + menuSelector.listOptions());
            menuSelector.selectOption(display.read());
        }
        display.println("Bye bye!");
    }

}
