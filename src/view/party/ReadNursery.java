package view.party;

import view.ConsoleUI;

public class ReadNursery extends Party{
    public ReadNursery(ConsoleUI consoleUI) {
        super("Прочитать дерево из записанного файла", consoleUI);
    }

    @Override
    public void execute() {
        String a = "HomeWorkJavaOOP/src/animalNurseru.txt";
        super.getConsoleUI().readNursery(a);
    }
}
