package model.writer;
import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String fileName);
    Object read(String fileName);
}
