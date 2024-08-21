package model.livingBegin;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import model.animalClass.Gender;


public interface LivingBeingInterf<T> extends Serializable {
    
    public void setGender(Gender gender);
    public void setName(String name);
    public Gender getGender();
    public int getAge();
    public String getName();
    public long getId();
    public LocalDate getBirtDate();
    public void setId(long id);
    public void setBirtDate(LocalDate birtDate);
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
    public String getCommands();
    public List<String> getCommandsList();
    public int hashCode();
    }
