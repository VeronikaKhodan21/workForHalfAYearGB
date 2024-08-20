package view.party;

import view.ConsoleUI;

public class SortByName  extends Party{
    public SortByName(ConsoleUI consoleUI) {
        super("Cортировка по имени", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().sortByName();
    }
}
