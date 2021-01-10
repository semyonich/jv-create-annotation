package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler consoleHandler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Enter value and risk(type 'q' to finish input):");
        consoleHandler.handleBet();
        System.out.println("Enter Login and Password for user(type 'q' to finish input):");
        consoleHandler.handleUser();
        System.out.println("All bets are:" + Factory.getBetDao().getAll());
        System.out.println("All users are:" + Factory.getUserDao().getAll());
    }
}
