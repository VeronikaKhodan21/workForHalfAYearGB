package model.animalClass;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.livingBegin.LivingBeingInterf;

public class Animal implements LivingBeingInterf<Animal>, Comparable<Animal>{
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birtDate;
    private List<String> commands;
    private TypeAnimal type;
    /**
     * 
     */
    public Animal(String name,  Gender gender, LocalDate birtDate, TypeAnimal type, ){
        id = -1;
        this.name = name;
        this.gender= gender;
        this.birtDate = birtDate;
        this.deatDate = deatDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birtDate){
    this(name, gender, birtDate, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birtDate,LocalDate deatDate ){
        this(name, gender, birtDate, deatDate, null, null);
    }
    public Human(String name, Gender gender, LocalDate birtDate, Human mother, Human father ){
        this(name, gender, birtDate, null, mother, father);
    }
    public boolean addChild(Human child){
        if (! children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public void setGender(Gender gender){this.gender = gender;}
    public void setName(String name){this.name = name;}
    public void setMother(Human mother){this.mother = mother;}
    public void setFather(Human father){this.father = father;}
    public Human getMother(){return mother;}
    public Human getFather(){return father;}
    public Gender getGender(){return gender;}

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }else if(parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>();
        if (father != null) {
            list.add(father);
        }if (mother!= null) {
            list.add(mother);
        }
        return list;
    }
    
    public int getAge(){
        if (deatDate == null) {
            return getPeriod(birtDate, LocalDate.now());
        }else{
            return getPeriod(birtDate, deatDate);
        }
    }
    private int getPeriod(LocalDate birtDate, LocalDate deatDate){
        Period diff = Period.between(birtDate, deatDate);
        return diff.getYears();
    }
    public void setSpouse(Human spouse){ this.spouse = spouse;}
    public Human getSpouse(){return spouse;}
    public String getName(){return name;}
    public long getId(){return id;}
    public LocalDate getBirtDate(){return birtDate;}
    public LocalDate getDeatDate(){return deatDate;}
    public List<Human> getChildren(){return children;}
    public void setId(long id){this.id = id;}
    public void setBirtDate(LocalDate birtDate){this.birtDate = birtDate;}
    public void setDeatDate(LocalDate deatDate){this.deatDate =deatDate;}
    @Override
    public String toString() {return getInfo(); }
    private String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", "); // Мать
        sb.append(getMotherInfo());
        sb.append(", "); //Отец
        sb.append(getFatherInfo());
        sb.append(", "); //Жена или муж
        sb.append(getSpouseInfo());
        sb.append(", "); // Список детей
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getSpouseInfo(){
        String res = "Супруг(а): ";
        if (spouse == null) {
            res += "нет";
        }else{
            res+= spouse.getName();
        }
        return res;
    }
    public String getMotherInfo(){
        String res = "Мать: ";
        if (mother != null) {
            res+= mother.getName();
        }else{
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "Отец: ";
        if (father != null) {
            res+= father.getName();
        }else{
            res += "неизвесттен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if (!children.isEmpty()) {
            sb.append(children.get(0).getName());
            for (int i= 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        }else{
            sb.append("отсутствуют");
        }
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }if(obj instanceof Human human){
            return human.getId() == getId();
        }
        return false;
    }
    public int hashCode() {
        return hashCode();
    }
    //@Override
    public int compareTo(Human o) {
        return birtDate.compareTo(o.getBirtDate());
    }
}
