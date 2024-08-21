package presenter;
import java.time.LocalDate;
import java.util.List;


import model.animalClass.*;
import model.livingBegin.LivingBeingInterf;
import model.service.Service;
import view.View;

public class Presenter<E extends LivingBeingInterf> {
    private View view;
    private Service service;

    
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void addAnimalNursery(String name, LocalDate dob, Gender gender, TypeAnimal type) {
        service.addToAnimalNursery(name, dob, gender, type);
    }
    public void addCommandAnimal(String command, int id){
        service.addCommandAnimal(command, service.);
    }
    public void getAnimalNursery() {
        List<Animal> res = service.getAnimalNurseryList();
        for (Animal e : res) {
            view.getAnswer("\n"+e.toString());
        }
    }
    private void printFamilyTree(List<Animal> animalNursery){
        for (Animal e : animalNursery) {
            view.getAnswer("\n"+e.toString());
        }
    }
    public void sortByName() {
        List<Animal> res = service.sortByName();
        this.printFamilyTree(res);
    }
    public void writeTreeFamily(String fileName) {
        //service.treeInFile(fileName);
        if (service.treeInFile(fileName) ) {
            view.getAnswer("Семья записана\n");
        } else {
            view.getAnswer("Семья не записана\n");
        }
    }
    public void readTreeFamily(String fileName) {
        
        FamilyTree<Human> tree = service.treeInputFile(fileName); 
        if (tree != null) {
            
            for (Human human : tree) {
                view.getAnswer("\n"+human.toString());
            }
        } else {
            view.getAnswer("Не удалось установить семью...");
        }
    }
    public void sortByDateBirth() {
        List<Animal> res =service.sortByBirthDate();
        this.printFamilyTree(res);
    }
    public void sortByGenger() {
        List<Animal> res =service.sortByGenger();
        this.printFamilyTree(res);
    }
    public void sortByAge() {
        List<Animal> res = service.sortByBirthDate();
        this.printFamilyTree(res);
    }
}
