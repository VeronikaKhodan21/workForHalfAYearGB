package view.party;

import view.ConsoleUI;

public  abstract class Party {
    private final String description;
    private final ConsoleUI consoleUI;

    public Party(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    } // доступен только внутри пакета command

    public abstract void execute();
}
