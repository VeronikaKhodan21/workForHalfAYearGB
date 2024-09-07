package presenter;
import java.time.LocalDate;
import java.util.List;
import model.animalClass.*;
import model.animalNursery.AnimalNursery;
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
    public void addAnimalNursery(String name, LocalDate dob, Gender gender, TypeAnimal type, String command) {
        boolean bol = service.addToAnimalNursery(name, dob, gender, type, command);
        if(bol){
            view.getAnswer("OK");
        }else{
            view.getAnswer("Ohhh...");
        }
    }
    public void addCommandAnimal(String command, int id){
        service.addCommandAnimal(command, service.getById(id));
    }
    public void getAnimalNursery() {
        List<Animal> res = service.getAnimalNurseryList();
        for (Animal e : res) {
            view.getAnswer("\n"+e.toString());
        }
    }
    private void printAnimalNursery(List<Animal> animalNursery ){
        for (Animal e : animalNursery) {
            view.getAnswer("\n"+e.toString());
        }
    }
    public int checkSuzeNursery(){
        return service.checkSuzeNursery()-1;
    }
    public void sortByName() {
        List<Animal> res = service.sortByName();
        this.printAnimalNursery(res);
    }
    
    public void writeNursery(String fileName) {
        service.nurseryInFile(fileName);
        if (service.nurseryInFile(fileName) ) {
            view.getAnswer("Питомник записан\n");
        } else {
            view.getAnswer("Питомник не записан\n");
        }
    }
    public void readNursery(String filrName) {
        AnimalNursery<Animal> nursery = service.nurseryInputFile(filrName);
        if (nursery != null) {
            
            for (Animal animal : nursery) {
                view.getAnswer("\n"+animal.toString());
            }
        } else {
            view.getAnswer("Не удалось установить питомник...");
        }
    }
    public void sortByDateBirth() {
        List<Animal> res =service.sortByBirthDate();
        this.printAnimalNursery(res);
    }
    public void sortByGenger() {
        List<Animal> res =service.sortByGenger();
        this.printAnimalNursery(res);
    }
    public void sortByAge() {
        List<Animal> res = service.sortByBirthDate();
        this.printAnimalNursery(res);
    } 
}
