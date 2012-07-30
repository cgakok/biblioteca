package com.twu28.biblioteca;

public class FakeTestDisplay extends Display {
    String outputBuffer = "";
    private String inputBuffer;

    @Override
    public void println(String message) {
        outputBuffer += message + "\n";
    }

    @Override
    public String read() {
        return inputBuffer;
    }

    public void setInput(String input) {
        this.inputBuffer = input;
    }

    public String getContent() {
        return outputBuffer.trim();
    }
}
