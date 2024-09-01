package view.party;

import view.ConsoleUI;

public class SortByGenger extends Party {
     public SortByGenger(ConsoleUI consoleUI) {
        super("Сортировка по гендеру", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().sortByGenger();
    }
}
