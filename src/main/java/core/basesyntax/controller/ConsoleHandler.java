package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String CONSOLE_CLOSE_COMMAND = "q";
    private static final String COMMAND_SPLITTING_SYMBOL = " ";
    private BetDao betDao = new BetDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void handleBet() {
        Scanner betScanner = new Scanner(System.in);
        while (true) {
            String command = betScanner.nextLine();
            if (command.equalsIgnoreCase(CONSOLE_CLOSE_COMMAND)) {
                return;
            }
            String[] betData = command.split(COMMAND_SPLITTING_SYMBOL);
            Bet bet = null;
            try {
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Bet input data format!");
            }
            betDao.add(bet);
            System.out.println(bet);
        }
    }

    public void handleUser() {
        Scanner userScanner = new Scanner(System.in);
        while (true) {
            String command = userScanner.nextLine();
            if (command.equalsIgnoreCase(CONSOLE_CLOSE_COMMAND)) {
                return;
            }
            String[] userData = command.split(COMMAND_SPLITTING_SYMBOL);
            User user = null;
            user = new User(userData[0], userData[1]);
            userDao.add(user);
            System.out.println(user);
        }
    }
}
