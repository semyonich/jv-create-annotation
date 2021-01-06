package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String CONSOLE_CLOSE_COMMAND = "q";
    private static final String COMMAND_SPLITTING_SYMBOL = " ";
    BetDao betDao = new BetDaoImpl();

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(CONSOLE_CLOSE_COMMAND)) {
                return;
            }
            String[] betdata = command.split(COMMAND_SPLITTING_SYMBOL);
            Bet bet = null;
            try {
                int value = Integer.parseInt(betdata[0]);
                double risk = Double.parseDouble(betdata[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input data format!");
            }
            betDao.add(bet);
            System.out.println(bet);
        }
    }
}
