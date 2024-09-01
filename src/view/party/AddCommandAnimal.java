package view.party;

import view.ConsoleUI;

public class AddCommandAnimal extends Party {
    public AddCommandAnimal(ConsoleUI consoleUI) {
        super("Добавить команду", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addCommandAnimal();
    }
}
