import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Serializable{
    private int id;
    private String name;
    private double cgpa;

    Student () {
        this.id = 0;
        this.name = "";
        this.cgpa = 0.0;
    }

    Student (int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public String toString () {
        return "[ ID: " + id + ", NAME: " + name + ", CGPA: " + cgpa + " ]";
    }

    int getId () {
        return id;
    }

    String getName () {
        return name;
    }

    double getCgpa () {
        return cgpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setCgpa(double cgpa) {
        if (cgpa >= 0 && cgpa <= 10) {
            this.cgpa = cgpa;
        }
    }
}
