package model.livingBegin;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import model.humanClass.Gender;


public interface LivingBeingInterf<T> extends Serializable {
    public boolean addChild(T e);
    public void setGender(Gender gender);
    public void setName(String name);
    public void setMother(T mother);
    public void setFather(T father);
    public T getMother();
    public T getFather();
    public Gender getGender();
    public boolean addParent(T e);
    public List<T> getParents();
    public int getAge();
    public void setSpouse(T spouse);
    public T getSpouse();
    public String getName();
    public long getId();
    public LocalDate getBirtDate();
    public LocalDate getDeatDate();
    public List<T> getChildren();
    public void setId(long id);
    public void setBirtDate(LocalDate birtDate);
    public void setDeatDate(LocalDate deatDate);
    public String toString();
    private String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(getId());
        sb.append(", имя: ");
        sb.append(getName());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        return sb.toString();
    }
    public String getSpouseInfo();
    public String getMotherInfo();
    public String getFatherInfo();
    public String getChildrenInfo();
    public int hashCode();
    }
