package model.service;
import java.time.LocalDate;
import java.util.List;
import model.animalClass.*;
import model.animalNursery.*;
import model.write.FileHandler;

public class Service{
    private long genId;
    private AnimalNursery<Animal> nursery;

    public Service(AnimalNursery<Animal> nursery) {this.nursery = nursery;}
    public Service() {this.nursery = new AnimalNursery<>();}
    public boolean addToAnimalNursery(String name, LocalDate birtDate, Gender gender, TypeAnimal type, String command) {

        Animal animal = new Animal(name, gender, birtDate, type);
        animal.setId(genId++);
        animal.addCommands(command);
        return this.nursery.add(animal);
    }
    public Animal findByName(String name) {
        Animal  animal = nursery.getByName(name);
        if (animal != null) return animal;
        return null;
    }
    public void addCommandAnimal(String command, Animal animal){
        animal.addCommands(command);
    }
    public int checkSuzeNursery(){return nursery.size();}
    public  Animal getById(int id){return nursery.getById(Long.valueOf(id));}
    public List<Animal> sortByGenger() {return nursery.sortByGenger();}
    public List<Animal> sortAge() {return nursery.sortByAge();}
    public List<Animal> sortByBirthDate() {return nursery.sortByBirthDate();}

    public List<Animal> sortByName() {return  nursery.sortByName();}
    public List<Animal> getAnimalNurseryList() {return nursery.getAnimalNurseryList();}
    
    public AnimalNursery<Animal> getAnimalNursery() {
        return nursery;
    }
    public AnimalNursery<Animal> nurseryInputFile(String filrName){
        if(deSerializableToNursery(filrName) != null){
           this.nursery = deSerializableToNursery(filrName);
        return deSerializableToNursery(filrName) ;   
        }else{
            return null;
        }
    }
    public boolean nurseryInFile(String nameFile){
        if(nameFile != null){
            serializableToTree( nameFile);
            return true;
        }else{
            return false;
        }  
    }

    private  boolean serializableToTree( String fileName){
        try {
            FileHandler fh = new FileHandler();
            fh.save(nursery, fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private AnimalNursery<Animal> deSerializableToNursery(String fileName) {
        try {
            FileHandler fh = new FileHandler();
            AnimalNursery<Animal> tree = (AnimalNursery<Animal>)fh.read(fileName);
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getListOfName(List<Animal> inputList) {
        return nursery.getListOfName(inputList);
    }
    public List<String> getListOfName() {
        return this.getAnimalNursery().getListOfNames();
    }
    
}
