package view.party;

import view.ConsoleUI;

public class WriteTreeInFile extends Party{
     public WriteTreeInFile(ConsoleUI consoleUI) {
        super("Записать семейное дерево в файл", consoleUI);
    }

    @Override
    public void execute() {
        String a = "HomeWorkJavaOOP/src/treeFamily.txt";
        super.getConsoleUI().writeTreeFamily(a);
    }
}
