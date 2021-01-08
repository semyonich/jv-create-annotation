package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        System.out.println("Enter value and risk(type 'q' to finish input):");
        consoleHandler.handleBet();
        System.out.println("Enter Login and Password for user(type 'q' to finish input):");
        consoleHandler.handleUser();
    }
}
