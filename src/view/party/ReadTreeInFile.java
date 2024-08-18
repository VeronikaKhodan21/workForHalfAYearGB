package view.party;

import view.ConsoleUI;

public class ReadTreeInFile extends Party {
    public ReadTreeInFile(ConsoleUI consoleUI) {
        super("Прочитать дерево из записанного файла", consoleUI);
    }

    @Override
    public void execute() {
        String a = "HomeWorkJavaOOP/src/treeFamily.txt";
        super.getConsoleUI().readTreeFamily(a);
    }
}
