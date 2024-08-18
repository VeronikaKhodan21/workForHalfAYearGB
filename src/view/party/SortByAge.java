package view.party;

import view.ConsoleUI;

public class SortByAge extends Party {
     public SortByAge(ConsoleUI consoleUI) {
        super("Сортировка по возрасту", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().sortByAge();
    }
}
