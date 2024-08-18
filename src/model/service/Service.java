package model.service;
import java.time.LocalDate;
import java.util.List;

import model.familyTree.FamilyTree;
import model.humanClass.Gender;
import model.humanClass.Human;
import model.writer.FileHandler;

public class Service{
    private long genId;
    private FamilyTree<Human> livingList;
    public Service(FamilyTree<Human> livingList) {
        this.livingList = livingList;
    }
    public Service() {
        this.livingList = new FamilyTree<>();
    }
    public boolean addToFamilyTree(String name, LocalDate birtDate, Gender gender) {
        Human human = new Human(name ,gender, birtDate);
        human.setId(genId++);
        livingList.add(human);
        return true;
    }


    public boolean addToFamilyTree(String name,LocalDate birtDate, Gender gender, Human father, Human mother) {
        Human human = new Human(name,gender,  birtDate,  (Human) father, (Human) mother);
        human.setId(genId++);
        livingList.add(human);
        return true;
    }

    public boolean addToFamilyTree(String name,Gender gender, LocalDate birtDate , LocalDate deatDate ) {
        Human human = new Human(name,  gender,birtDate , deatDate );
        human.setId(genId++);
        livingList.add(human);
        return true;
    }
    public void setParentsForSubject(String nameForSearching, Human parent) {
        if (findByName(nameForSearching) != null) {
            findByName(nameForSearching).addParent(parent);
        }
    }
    public Human findByName(String name) {
        Human  livingBeing = livingList.getByName(name);
        if (livingBeing != null) return livingBeing;
        return null;
    }
    public List<Human> sortByGenger() {
        return livingList.sortByGenger();
    }
    public List<Human> sortAge() {
        return livingList.sortByAge();
    }
    public List<Human> sortByBirthDate() {
        return livingList.sortByBirthDate();
    }

    public List<Human> sortByName() {
        List<Human> a =  livingList.sortByName();
        return a;
    }
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
    public List<Human> getFamilyTreeList() {
        return livingList.getFamilyTreeList();
    }
    public FamilyTree<Human> getFamilyTree() {
        return livingList;
    }
    public FamilyTree<Human> treeInputFile(String filrName){
        if(deSerializableToTree(filrName) != null){
           this.livingList = deSerializableToTree(filrName);
        return deSerializableToTree(filrName) ;   
        }else{
            return null;
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
    public List<String> getListOfName(List<Human> inputList) {
        return livingList.getListOfName(inputList);
    }
    public List<String> getListOfName() {
        return this.getFamilyTree().getListOfNames();
    }
}
