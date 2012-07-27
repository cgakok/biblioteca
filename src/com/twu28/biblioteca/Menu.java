package com.twu28.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuOptions;
    private Display display;

    public Menu(ArrayList<String> menuOptions, Display display) {
        this.menuOptions = menuOptions;
        this.display = display;
    }

    public ArrayList<String> listMenuOptions() {
        return menuOptions;
    }

    public void select(String selected, Collection collection, String message) throws IOException {

        if (selected.equals("view"))  {
            ArrayList<String> books = collection.listAllBooks();
            for (String book : books) {
                display.println(book);
            }
        } else if(selected.equals("retrieve")) {
            display.println("Please talk to Librarian. Thank you.");

        } else if(selected.equals("reserve")) {
            String input = display.read(message);
            display.println(collection.makeReservation(input));
        } else if(selected.equals("quit")) {
            display.println("Bye bye!");
        }
        else {
            display.println("Select a valid option!!");
        }



    }
}
