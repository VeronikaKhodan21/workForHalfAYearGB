package model.sortFamily;

import java.util.Comparator;

import model.livingBegin.LivingBeingInterf;

public class ByAgeSort<E extends LivingBeingInterf> implements Comparator<E> {
    @Override 
    public int compare(E o1, E o2){return  Integer.compare(o1.getAge(), o2.getAge());}
}

