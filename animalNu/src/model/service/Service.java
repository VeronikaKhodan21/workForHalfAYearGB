package model.service;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.sql.*;
import model.animalNursery.*;
import model.animalClass.*;
import java.util.Properties;

public class Service{
    private long genId;
    private AnimalNursery<Animal> nursery;

    public Service(AnimalNursery<Animal> nursery) {this.nursery = nursery;}
    public Service() {this.nursery = new AnimalNursery<>();}
    public boolean addToAnimalNursery(String name, LocalDate birtDate, Gender gender, TypeAnimal type) {

        Animal animal = new Animal(name ,gender, birtDate, type);
        animal.setId(genId++);
        nursery.add(animal);
        return true;
    }
    public boolean addCommandAnimal(String command, Animal animal, int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {
                String SQLstr = "INSERT INTO pet_command (PetId, CommandId) SELECT ?, (SELECT Id FROM commands WHERE Command_name = ?)";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLstr);
                prepSt.setInt(1, id);
                prepSt.setString(2, command);
                prepSt.executeUpdate();
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } 
        return animal.addCommands(command);
    }
    public Animal findByName(String name) {
        Animal  animal = nursery.getByName(name);
        if (animal != null) return animal;
        return null;
    }
    public int update(Animal animal) {
        int rows;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {
                String SQLstr = "UPDATE pet_list SET PetName = ?, Birthday = ? WHERE Id = ?";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLstr);

                prepSt.setString(1, animal.getName());
                prepSt.setDate(2, Date.valueOf(animal.getBirtDate())); 
                prepSt.setInt(3, (int)animal.getId());
                rows = prepSt.executeUpdate();
                return rows;
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } 
    }
    public int checkSuzeNursery(){return nursery.size();}
    public  Animal getById(int id){return nursery.getById(new Long(id));}
    public List<Animal> sortByGenger() {return nursery.sortByGenger();}
    public List<Animal> sortAge() {return nursery.sortByAge();}
    public List<Animal> sortByBirthDate() {return nursery.sortByBirthDate();}

    public List<Animal> sortByName() {return  nursery.sortByName();}
    public List<Animal> getAnimalNurseryList() {return nursery.getAnimalNurseryList();}
    public AnimalNursery<Animal> getFamilyTree() {
        return nursery;
    }
    /* 
    public boolean treeInFile(String nameFile){
        if(nameFile != null){
            serializableToTree(livingList, nameFile);
            return true;
        }else{
            return false;
        }  
    }*/
    // В базу данных
    /* 
    private  boolean serializableToTree(AnimalNursery<Animal> tr){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");
            FileHandler fh = new FileHandler();
            fh.save(tr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
    // из базы данных

    public AnimalNursery<Animal> deSerializableToNursery() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {
                Statement sqlSt = dbConnection.createStatement();
                String SQLstr = "SELECT GenusId, Id, PetName, Birthday, Gender FROM pet_list ORDER BY Id";
                ResultSet resultSet = sqlSt.executeQuery(SQLstr);
                while (resultSet.next()) {

                    TypeAnimal type = getTypeSql(resultSet.getString(1));
                    String name = resultSet.getString(2);
                    LocalDate birthday = resultSet.getDate(3).toLocalDate();
                    Gender gen = getGender(resultSet.getString(4));
                    addToAnimalNursery(name, birthday, gen, type);
                }
                return nursery;
            } 
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    private TypeAnimal getTypeSql(String str){
        if (str.toLowerCase().contains("dog"))  return TypeAnimal.Dog;
        if (str.toLowerCase().contains("cat"))  return TypeAnimal.Cat;
        if (str.toLowerCase().contains("camel"))  return TypeAnimal.Camel;
        if (str.toLowerCase().contains("donkey"))  return TypeAnimal.Donkey;
        if (str.toLowerCase().contains("hamster"))  return TypeAnimal.Hamster;
        if (str.toLowerCase().contains("horse"))  return TypeAnimal.Horse;
        return  null;
    }
    private Gender getGender(String str){
        if (str.toLowerCase().contains("femel"))  return Gender.Female;
        if (str.toLowerCase().contains("mele"))  return Gender.Male; 
        return null;
    }
    /* 
    public FamilyTree<Human> treeInputFile(String filrName){
        if(deSerializableToTree(filrName) != null){
           this.livingList = deSerializableToTree(filrName);
        return deSerializableToTree(filrName) ;   
        }else{
            return null;
        }
    }
    */
    public List<String> getListOfName(List<Animal> inputList) {
        return nursery.getListOfName(inputList);
    }
    public List<String> getListOfName() {
        return this.getFamilyTree().getListOfNames();
    }
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/resources/database.properties")) {

            props.load(fis);
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            return DriverManager.getConnection(url, username, password);
        }
    }
    
}
