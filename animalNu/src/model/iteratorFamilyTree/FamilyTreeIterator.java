package model.iteratorFamilyTree;
import java.util.Iterator;
import java.util.List;

import model.humanClass.Human;

public class FamilyTreeIterator implements Iterator<Human>   {
    private int index;
    private List<Human> humanList;
    public FamilyTreeIterator(List<Human> humans){
        this.humanList = humans;
    }
    @Override
    public boolean hasNext(){
        return index < humanList.size();
    }
    @Override
    public Human next(){
        return humanList.get(index++);
    }
}