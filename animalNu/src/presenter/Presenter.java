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
    public void addAnimalNursery(String name, LocalDate dob, Gender gender, TypeAnimal type) {
        service.addToAnimalNursery(name, dob, gender, type);
    }
    public void addCommandAnimal(String command, int id){
        service.addCommandAnimal(command, service.getById(id), id);
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
        return service.checkSuzeNursery();
    }
    public void sortByName() {
        List<Animal> res = service.sortByName();
        this.printAnimalNursery(res);
    }
    
    public void readTreeFamily() {
        AnimalNursery<Animal> nursery = service.deSerializableToNursery();
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
