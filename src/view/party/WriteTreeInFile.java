package view.party;

import view.ConsoleUI;

public class WriteTreeInFile extends Party{
     public WriteTreeInFile(ConsoleUI consoleUI) {
        super("Получить питомник из базы данных", consoleUI);
    }

    @Override
    public void execute() {
        String a = "HomeWorkJavaOOP/src/animalNursery.txt";
        super.getConsoleUI().readNursery(a);
    }
}
