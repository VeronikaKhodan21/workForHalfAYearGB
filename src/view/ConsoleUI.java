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

    public  void addCommandAnimal(){
        int id = getIdAnimalForCommand();
        String command = scanner.nextLine();
            presenter.addCommandAnimal(command, id);
    }
    private boolean checkId(int id) {
        if (id > presenter.checkSuzeNursery()) {
            return false;
        }
        return true;
    }

    private int getIdAnimalForCommand(){
        try{
            System.out.println("Введите номер животного, которому хотите добавить команду:");
            int id = Integer.parseInt(scanner.nextLine());
            if(checkId(id)){
              return id;  
            }
            System.out.println("Нету животного с таким id");
            return getIdAnimalForCommand();
        }catch (NumberFormatException e) {
            System.out.println("Вы ввели не число");
            return getIdAnimalForCommand();
        }
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
        LocalDate birthDate = getDateBirht();
        Gender gender = setGender();
        TypeAnimal type = setTypeAnimal();
        
        presenter.addAnimalNursery(name, birthDate, gender, type);
    }
    private int getYears(int year, Scanner scan){
        if (LocalDate.now().getYear() < year) {
            try {
                System.out.println("Введите год рождения животного");
                String str = scanner.nextLine();
                int mon1 = Integer.parseInt(str);
                year = mon1;
                if(checkYear(year)){
                    return year;
                }
                System.out.println("Животное не могло родиться в этот год");
                return getYears(year, scan);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
                return getYears(year, scan);
            }
        } else {
           return year; 
        }
    }
    private boolean checkYear(int year){
        if (year > LocalDate.now().getYear()) {
            return false;
        }
        return true;
    }
    private Gender setGender() {
        System.out.println("Введите гендер (male или female): ");
        String strGender = scanner.nextLine();
        Gender gender = Gender.Male;
        if (strGender.toLowerCase().contains("female")) gender = Gender.Female;
        if(strGender.toLowerCase().contains("male")) return gender;
        else{
            System.out.println("Вы ввели не гендер... /nПопробуйте еще раз");
            return setGender();
        } 
    }

    private LocalDate getDateBirht(){
        Scanner scan = this.scanner;
        int b = 0;
        int lDate = LocalDate.now().getYear()+1;
        int day = getDay(b, scan);
        int month = getMonth(b, scan);
        int  year = getYears(lDate,scan);
        LocalDate lD = LocalDate.of(year, month, day);
        if (lD.isAfter(LocalDate.now()) == true) {
            System.out.println("Животное не могло родиться в эту дату");
            return getDateBirht();
        }
        return lD;
    }
    private int getDay(int num, Scanner scan){
        if (num <= 0 | num>31 ) {
           try{
            System.out.println("Введите день рождения животного");
            String str = scanner.nextLine();
            int num1 = Integer.parseInt(str);
            num = num1;
            if (gatDay(num1)) {
                return num;
            }
                System.out.println("Животное не могло родиться в этот день");
                return getDay(num, scan);
            
           }catch(NumberFormatException e){
                System.out.println("Вы ввели не число \nПопробуйте еще раз");
                return getDay(num, scan);
           }
        }else{
            return num;
        }
    }
    private boolean gatDay(int num){
        if(num <= 0 | num >31){
            return false;
        }
        return true;
    }
    private int getMonth(int month, Scanner scan){
        if (month <= 0 | month > 12) {
            try {
                System.out.println("Введите месяц рождения животного");
                String str = scanner.nextLine();
                int num1 = Integer.parseInt(str);
                month = num1;
                if(gatMonth(month)){
                    return month;
                }
                System.out.println("Животное не могло родиться в этот месяц");
                return getMonth(month, scan);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число\n Попробуйте еще раз");
                return getMonth(month, scan);
            }
        } else {
            return month;
        }
    }
    private boolean  gatMonth(int month){
        if (month <= 0| month >12) {
            return false;
        }
        return true;
    }
    private TypeAnimal setTypeAnimal(){
        System.out.println("Введите вид животного: ");
        String strTypeAnimal = scanner.nextLine();
        TypeAnimal typ = definitionTypeAnimal(strTypeAnimal);
        if(typ == null){
            System.out.println("Такого животного нету или вы ввели не типи животного");
            return setTypeAnimal();
        }
        return typ;
    }
    private TypeAnimal definitionTypeAnimal(String strTypeAnimal){
        if (strTypeAnimal.toLowerCase().contains("dog"))  return TypeAnimal.Dog;
        if (strTypeAnimal.toLowerCase().contains("cat"))  return TypeAnimal.Cat;
        if (strTypeAnimal.toLowerCase().contains("camel"))  return TypeAnimal.Camel;
        if (strTypeAnimal.toLowerCase().contains("donkey"))  return TypeAnimal.Donkey;
        if (strTypeAnimal.toLowerCase().contains("hamster"))  return TypeAnimal.Hamster;
        if (strTypeAnimal.toLowerCase().contains("horse"))  return TypeAnimal.Horse;
        else{return null;}
    }
    private String setNameForNewSubject() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        return name;
    }
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
    public void readNursery(String filrName) {
        presenter.readNursery(filrName);
    }
}