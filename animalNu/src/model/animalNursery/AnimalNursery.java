package model.animalNursery;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import model.iteratorAnimalNursery.AnimalNurseryIterator;
import model.livingBegin.LivingBeingInterf;
import model.sortFamily.*;

public class AnimalNursery<E extends LivingBeingInterf<E>> implements Serializable, Iterable<E>{
    private long count;
    private  List<E> livingList;
    public AnimalNursery(List<E> livingList){
        this.livingList = livingList;
    }
    public AnimalNursery(){
        this(new ArrayList<>());
    }
    public boolean add(E e){
        if(e == null){
            return false;
        }if (!livingList.contains(e)) {
            livingList.add(e);
            return true;
        } 
        return false;
        
    }
    public E getByName(String name){
        for (E person : this) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
            if (person.getName().contains(name)) {
                return person;
            }
        }
        return null;

    }
    public E getByBirthDate(LocalDate birthDate){
        for (E person : this) {
            if (person.getBirtDate().isEqual(birthDate)) {
                return person;
            }
            // if (person.getBirtDate().contains(birthDate)) {
            //     return person;
            // }
        }
        return null;

    }
    public int size(){
        return livingList.size();
    }
    private  boolean checkId(long id){
        return id < count && id >= 0;
    }
    public E getById(long id){
        if (checkId(id)) {
            for (E e: livingList) {
                if(e.getId() == id){
                    return e;
                }
            }
        }
        return null;
    }@Override
    public String toString() { return getInfo();}
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В питомнике ");
        sb.append(livingList.size());
        sb.append(" животных: \n");
        for (E e : livingList) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }
    public List<E> getAnimalNurseryList(){
        return livingList;
    }
    public List<String> getListOfNames() {
        List<String> listOfNames = new ArrayList<>();
        for (E item : this) {
            listOfNames.add(item.getName() + "\n");
        }
        return listOfNames;
    }
    public List<String> getListOfName(List<E > inputList) {
        List<String> listOfNames = new ArrayList<>();
        for (E item : inputList) {
            listOfNames.add(item.getName() + "\n");
        }
        return listOfNames;
    }  
    @Override
    public Iterator<E> iterator() {
        return new AnimalNurseryIterator<E>(livingList);
    }
    public List<E> sortByBirthDate(){
        List<E>  a = this.livingList;
        a.sort(new ByBirshDateSort<E>());
        return a;
    }
    public List<E> sortByGenger(){
        List<E>  a = this.livingList;
        a.sort(new ByGengerSort<E>());
        return a;
    }
    public List<E> sortByName(){
        List<E>  a = this.livingList;
        a.sort(new ByNameSort<E>());
        return a;
        
    }
    public List<E> sortByAge(){
        List<E>  a = this.livingList;
        a.sort(new ByAgeSort<E>());
        return a;
        
    }
}
