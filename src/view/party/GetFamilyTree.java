package view.party;

import view.ConsoleUI;

public class GetFamilyTree extends Party {
    public GetFamilyTree(ConsoleUI consoleUI) {
        super("Пролучить семейное дерево", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().getFamilyTree();
    }
}
