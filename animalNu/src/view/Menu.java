package view;

import java.util.ArrayList;
import java.util.List;
import view.party.*;

public class Menu {
    private final List<Party> commands;

    public Menu(ConsoleUI consoleUI) {
        this.commands = new ArrayList<>();
        commands.add(new AddAnimalNursery(consoleUI));
        commands.add(new GetAnimalNursery(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByGenger(consoleUI));
        commands.add(new WriteTreeInFile(consoleUI));
        commands.add(new ReadTreeInFile(consoleUI));
        commands.add(new AddCommandAnimal(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public int getNumberOfCommands() {
        return commands.size();
    }
    public String getMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nФункции:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1).append(". ")
                    .append(commands.get(i).getDescription()).append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Party command = commands.get(choice - 1);
        command.execute();
    }
}
