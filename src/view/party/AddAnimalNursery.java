package view.party;

import view.ConsoleUI;

public class AddAnimalNursery extends Party {
    public AddAnimalNursery(ConsoleUI consoleUI) {
        super("Добавить в питомник", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addNewSubjectToAnimalNursery();
    }
}
