package model.write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler {
     public boolean save(Serializable serializable, String fileName){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))){
            os.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Object read(String fileName){
        try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(fileName))) {
            return  os.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
