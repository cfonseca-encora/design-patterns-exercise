package oop.inheritance;

import oop.inheritance.data.SupportedTerminal;

public class Main {

    public static void main(String[] args) {
        //Abstract Factory should instantiate first, receive supported terminal and then send itself through application
        Application application = new Application(SupportedTerminal.INGENICO);

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
