package view.party;

import view.ConsoleUI;

public class ReadNursery extends Party{
    public ReadNursery(ConsoleUI consoleUI) {
        super("Прочитать питомник из записанного файла", consoleUI);
    }

    @Override
    public void execute() {
        String a = "C:/Users/veron/training/ПолугодовоеДЗ/workForHalfAYearGB/nursery/Nursery.txt";
        super.getConsoleUI().readNursery(a);
    }
}
