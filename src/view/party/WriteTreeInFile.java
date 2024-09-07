package view.party;

import view.ConsoleUI;

public class WriteTreeInFile extends Party{
     public WriteTreeInFile(ConsoleUI consoleUI) {
        super("Записать питомник", consoleUI);
    }

    @Override
    public void execute() {
        String a = "C:/Users/veron/training/ПолугодовоеДЗ/workForHalfAYearGB/nursery/Nursery.txt";
        super.getConsoleUI().writeNursery(a);
    }
}
