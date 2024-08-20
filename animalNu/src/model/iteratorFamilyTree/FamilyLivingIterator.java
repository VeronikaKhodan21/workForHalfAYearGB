package model.iteratorFamilyTree;


import java.util.Iterator;
import java.util.List;

public class FamilyLivingIterator<E> implements Iterator<E>   {
        private int index;
        private List<E> livingList;
        public FamilyLivingIterator(List<E> livList){
            this.livingList = livList;
        }
        @Override
        public boolean hasNext(){
            return index < livingList.size();
        }
        @Override
        public E next(){
            return livingList.get(index++);
        }
    
}
