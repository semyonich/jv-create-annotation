package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Enter value and risk(type 'q' to finish input):");
        consoleHandler.handle();
    }
}
