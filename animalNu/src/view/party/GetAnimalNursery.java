package view.party;

import view.ConsoleUI;

public class GetAnimalNursery extends Party {
    public GetAnimalNursery(ConsoleUI consoleUI) {
        super("Пролучить питомник", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().getFamilyTree();
    }
}
