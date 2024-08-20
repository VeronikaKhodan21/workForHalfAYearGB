package presenter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import model.familyTree.FamilyTree;
import model.humanClass.Gender;
import model.humanClass.Human;
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
    public void addToFamilyTree(String name, LocalDate dob, LocalDate dod, Gender gender) {
        service.addToFamilyTree(name, gender,dob, dod );
    }
    public void getFamilyTree() {
        List<Human> res = service.getFamilyTreeList();
        for (Human e : res) {
            view.getAnswer("\n"+e.toString());
        }
        
    }
    private void printFamilyTree(List<Human> familyTree){
        for (Human e : familyTree) {
            view.getAnswer("\n"+e.toString());
        }
    }
    public void sortByName() {
        List<Human> res = service.sortByName();
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
        List<Human> res =service.sortByBirthDate();
        this.printFamilyTree(res);
    }
    public void sortByGenger() {
        List<Human> res =service.sortByGenger();
        this.printFamilyTree(res);
    }
    public void sortByAge() {
        List<Human> res = service.sortByBirthDate();
        this.printFamilyTree(res);
    }
}
