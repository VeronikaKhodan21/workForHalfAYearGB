package view.party;

import view.ConsoleUI;

public class AddLivingBegin extends Party {
    public AddLivingBegin(ConsoleUI consoleUI) {
        super("Добавить в семейное дерево", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addNewSubjectToFamilyTree();
    }
}
