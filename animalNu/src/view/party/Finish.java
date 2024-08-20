package view.party;

import view.ConsoleUI;

public class Finish  extends Party{
    public Finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().finish();
    }
}
