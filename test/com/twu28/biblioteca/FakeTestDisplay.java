package com.twu28.biblioteca;

public class FakeTestDisplay extends Display {

    String outputBuffer = "";

    @Override
    public void println(String message) {
        outputBuffer += message + "\n";
    }

    @Override
    public String getContent() {
        return outputBuffer.trim();
    }

    @Override
    public String read(String input) {
        return input;
    }
}
