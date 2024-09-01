package model.iteratorAnimalNursery;


import java.util.Iterator;
import java.util.List;

public class AnimalNurseryIterator<E> implements Iterator<E>   {
        private int index;
        private List<E> livingList;
        public AnimalNurseryIterator(List<E> livList){
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
