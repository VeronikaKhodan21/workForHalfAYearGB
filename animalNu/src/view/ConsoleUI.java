
package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.animalClass.*;
import presenter.Presenter;


/**
 * ConsoleUI
 */
public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    boolean work;
    private Menu mainMenu;
    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        presenter = new Presenter<Animal>(this);
        work = true;
        mainMenu = new Menu(this);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            int choice = checkUserChoice(getUserChoice());
            if (choice != 0) mainMenu.execute(choice);
            else System.out.println("Вы ввели не коректные данные :(\nПожалуста введите команду снова");
        }
    }
    private String getUserChoice() {
        System.out.println(mainMenu.getMenu());
        String strChoice = scanner.nextLine();
        return strChoice;
    }

    private int checkUserChoice(String userChoice) {
        int choice = 0;
        if (userChoice.matches("\\d")) {
            choice = Integer.parseInt(userChoice);
        } else {
            return choice;
        }
        if ((choice > 0) && (choice <= mainMenu.getNumberOfCommands())) return choice;
        else {
            choice = 0;
        }
        return choice;
    }

    private void addCommandAnimal(){
        presenter.addCommandAnimal();
    }

    private static void hello() {
        System.out.println("Привет");
    }

    public void sortByName() {
        presenter.sortByName();
    }
    public void sortByGenger(){
        presenter.sortByGenger();
    }
    public void getFamilyTree() {
        presenter.getAnimalNursery();
    }

    public void sortByDateBirth() {
        presenter.sortByDateBirth();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }
    public void addNewSubjectToAnimalNursery() {
        String name = setNameForNewSubject();
        LocalDate birthDate = setDateOfBirth();
        Gender gender = setGender();
        TypeAnimal type = setTypeAnimal();

        presenter.addAnimalNursery(name, birthDate, gender, type);
    }

    private Gender setGender() {
        System.out.println("Введите гендер (male или female): ");
        String strGender = scanner.nextLine();
        Gender gender = Gender.Male;
        if (strGender.toLowerCase().contains("fe")) gender = Gender.Female;
        return gender;
    }

    private LocalDate setDateOfBirth() {
        System.out.println("Дата рождения ");
        System.out.print("Год рождения: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Месяц рождения: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("День рождения: ");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        return dateOfBirth;
    }
    private TypeAnimal setTypeAnimal(){
        System.out.println("Введите вид животного: ");
        String strTypeAnimal = scanner.nextLine();
        return definitionTypeAnimal(strTypeAnimal);
    }
    private TypeAnimal definitionTypeAnimal(String strTypeAnimal){
        if (strTypeAnimal.toLowerCase().contains("dog"))  return TypeAnimal.Dog;
        if (strTypeAnimal.toLowerCase().contains("cat"))  return TypeAnimal.Cat;
        if (strTypeAnimal.toLowerCase().contains("camel"))  return TypeAnimal.Camel;
        if (strTypeAnimal.toLowerCase().contains("donkey"))  return TypeAnimal.Donkey;
        if (strTypeAnimal.toLowerCase().contains("hamster"))  return TypeAnimal.Hamster;
        if (strTypeAnimal.toLowerCase().contains("horse"))  return TypeAnimal.Horse;
        return TypeAnimal.Camel;
    }
    private String setNameForNewSubject() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        return name;
    }

    // private void setClassForFamilyTree() {
    //     System.out.println("Введите тип обЬекта(человек или другое(других нету :-( ))): ");
    //     String type = scanner.nextLine();
    //     if (type.equalsIgnoreCase("Человек")) {
    //         Class clazz = Human.class;
    //     }
    //     Class clazz = Human.class;
    // }

    public void finish() {
        System.out.println("Пока ");
        scanner.close();
        work = false;
    }

    @Override
    public void getAnswer(String text) {
        System.out.print(text);
    }

    public void writeTreeFamily(String fileName) {
        presenter.writeTreeFamily(fileName);
    }

    public void readTreeFamily(String fileName) {
        presenter.readTreeFamily(fileName);
    }
}




