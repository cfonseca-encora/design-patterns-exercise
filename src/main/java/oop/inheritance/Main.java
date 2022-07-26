package oop.inheritance;

import oop.inheritance.core.abstractfactory.ITerminalFactory;
import oop.inheritance.core.abstractfactory.TerminalFactory;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;

public class Main {

    public static void main(String[] args) {
        //Abstract Factory should instantiate first, receive supported terminal and then send itself through application
        ITerminalFactory terminalFactory = TerminalFactory.getInstance(SupportedTerminal.INGENICO, CommunicationType.ETHERNET);
        Application application = new Application(terminalFactory);

        while (true) {
            run(application);
        }
    }

    public static void run(Application application) {
        application.clearScreen();
        application.showMenu();

        String key = application.readKey();

        switch (key) {
            case "1" -> application.doSale();
            case "2" -> application.doRefund();
            case "3" -> application.printReport();
            case "4" -> application.showConfiguration();
        }
    }

}
