package com.twu28.biblioteca;

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
}
