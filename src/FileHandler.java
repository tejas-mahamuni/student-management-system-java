import java.io.*;
import java.util.*;

public class FileHandler {
    File file = new File("D:\\Super30\\Student Management System - File Handling\\student.dat");

    public void writeToFile(ArrayList<Student> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {

            out.writeObject(list);

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public ArrayList<Student> readFromFile() {
        ArrayList<Student> list = new ArrayList<>();

        if (!file.exists()) {
            return list;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            list = (ArrayList<Student>) in.readObject();

        }catch (EOFException e) {

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        return list;
    }


}
