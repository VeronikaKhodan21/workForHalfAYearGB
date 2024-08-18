package view.party;

import view.ConsoleUI;

public class SortByBirthDate extends Party {
     public SortByBirthDate(ConsoleUI consoleUI) {
        super("Сортировка по дате рождения", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().sortByDateBirth();
    }
}
