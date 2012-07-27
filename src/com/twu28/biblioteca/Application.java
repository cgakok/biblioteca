package com.twu28.biblioteca;

import java.util.ArrayList;

public class Application {

    private Display display;

    public Application(Display display) {
        this.display = display;
    }

    public static void main(String[] args){
        new Application(new Display()).showWelcomeMessage();
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
        return new Menu(options, display);
    }

    public Collection createCollection() {
        ArrayList<String> books = new ArrayList<String>();
        books.add("A Game of Thrones");
        books.add("A Clash of Kings");
        books.add("A Storm of Swords");
        return new Collection(books);
    }
}
