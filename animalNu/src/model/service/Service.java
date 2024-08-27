package model.service;
import java.time.LocalDate;
import java.util.List;

import model.animalNursery.*;
import model.animalClass.*;

public class Service{
    private long genId;
    private AnimalNursery<Animal> nursery;

    public Service(AnimalNursery<Animal> nursery) {
        this.nursery = nursery;
    }
    public Service() {
        this.nursery = new AnimalNursery<>();
    }
    public boolean addToAnimalNursery(String name, LocalDate birtDate, Gender gender, TypeAnimal type) {
        Animal animal = new Animal(name ,gender, birtDate, type);
        animal.setId(genId++);
        nursery.add(animal);
        return true;
    }
    public boolean addCommandAnimal(String command, Animal animal){
        return animal.addCommands(command);
    }
    public Animal findByName(String name) {
        Animal  animal = nursery.getByName(name);
        if (animal != null) return animal;
        return null;
    }
    public int checkSuzeNursery(){
        return nursery.size();
    }
    public  Animal getById(int id){
        return nursery.getById(new Long(id));
    }
    public List<Animal> sortByGenger() {
        return nursery.sortByGenger();
    }
    public List<Animal> sortAge() {
        return nursery.sortByAge();
    }
    public List<Animal> sortByBirthDate() {
        return nursery.sortByBirthDate();
    }

    public List<Animal> sortByName() {
        return  nursery.sortByName();
    }
    public List<Animal> getAnimalNurseryList() {
        return nursery.getAnimalNurseryList();
    }
    public AnimalNursery<Animal> getFamilyTree() {
        return nursery;
    }
    /* 
    public boolean treeInFile(String nameFile){
        if(nameFile != null){
            serializableToTree(livingList, nameFile);
            return true;
        }else{
            return false;
        }  
    }
    private  boolean serializableToTree(FamilyTree<Human> tr, String fileName){
        try {
            FileHandler fh = new FileHandler();
            fh.save(tr, fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private FamilyTree<Human> deSerializableToTree(String fileName) {
        try {
            FileHandler fh = new FileHandler();
            FamilyTree<Human> tree = (FamilyTree<Human>)fh.read(fileName);
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public FamilyTree<Human> treeInputFile(String filrName){
        if(deSerializableToTree(filrName) != null){
           this.livingList = deSerializableToTree(filrName);
        return deSerializableToTree(filrName) ;   
        }else{
            return null;
        }
    }
    
    public List<String> getListOfName(List<Human> inputList) {
        return livingList.getListOfName(inputList);
    }
    public List<String> getListOfName() {
        return this.getFamilyTree().getListOfNames();
    }*/
    
    
}
