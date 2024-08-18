package model.sortFamily;
import java.util.Comparator;

import model.livingBegin.LivingBeingInterf;

public class ByBirshDateSort<E extends LivingBeingInterf> implements Comparator<E> {
    @Override 
    public int compare(E o1, E o2){return o1.getBirtDate().compareTo(o2.getBirtDate());}
}
