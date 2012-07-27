package com.twu28.biblioteca;

import java.io.IOException;

public class Display {

    public void println(String message){
        System.out.println(message);
    }

    public String getContent() {
        return "";
    }

    public String read(String input) throws IOException {
        return System.console().readLine().trim();
    }
}
