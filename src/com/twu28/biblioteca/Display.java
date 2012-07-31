package com.twu28.biblioteca;

import java.io.IOException;
import java.util.Scanner;

public class Display {
    public void println(String message) {
        System.out.println(message);
    }

    public String read() throws IOException {
        return new Scanner(System.in).nextLine();
    }

}
