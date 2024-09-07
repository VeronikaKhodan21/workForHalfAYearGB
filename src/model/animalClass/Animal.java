package model.animalClass;
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
    public Animal(String name,  Gender gender, LocalDate birtDate, TypeAnimal type){
        id = -1;
        this.name = name;
        this.gender= gender;
        this.birtDate = birtDate;
        this.type = type;        
        this.commands =  new ArrayList<>();
    }
    public void setId(long id){this.id = id;}
    public void setGender(Gender gender){this.gender = gender;}
    public void setName(String name){this.name = name;}
    public TypeAnimal getTypeAnimal(){return type;}
    public Gender getGender(){return gender;}

    public boolean addCommands(String command){
        if(commands == null){
            this.commands = new ArrayList<>();
            return commands.add(command);
        }else{
            // List<String> list = new ArrayList<String>(Arrays.asList(command.split(",")));
            commands.add(command);
        }
        return true;
    }
    // public  int  getId(){return id ;}
    public int getAge(){
        return getPeriod(birtDate, LocalDate.now());
    }
    private int getPeriod(LocalDate birtDate, LocalDate deatDate){
        Period diff = Period.between(birtDate, deatDate);
        return diff.getYears();
    }
    public void  addCommandOneY(String command){
        commands.add(command);
        //return true;
    }
    public String getCommands(){
        return String.join(", ", this.commands);

    }
    public List<String> getCommandsList(){
        return this.commands;
    }
    public String getName(){return name;}
    public long getId(){return id;}
    public LocalDate getBirtDate(){return birtDate;}
    public void setBirtDate(LocalDate birtDate){this.birtDate = birtDate;}
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
        sb.append(", вид животного: ");
        sb.append(getTypeAnimal()); 
        sb.append(", команды которые умеет животное: ");
        sb.append(getCommands());
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }if(obj instanceof Animal animal){
            return animal.getId() == getId();
        }
        return false;
    }
    public int hashCode() {
        return hashCode();
    }
    //@Override
    public int compareTo(Animal o) {
        return birtDate.compareTo(o.getBirtDate());
    }
}
