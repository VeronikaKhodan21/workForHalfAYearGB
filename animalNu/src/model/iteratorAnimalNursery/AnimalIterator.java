package model.iteratorAnimalNursery;
import java.util.Iterator;
import java.util.List;

import model.animalClass.*;

public class AnimalIterator implements Iterator<Animal>   {
    private int index;
    private List<Animal> humanList;
    public AnimalIterator(List<Animal> humans){
        this.humanList = humans;
    }
    @Override
    public boolean hasNext(){
        return index < humanList.size();
    }
    @Override
    public Animal next(){
        return humanList.get(index++);
    }
}