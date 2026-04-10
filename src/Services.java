import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Services {

    FileHandler fileHandler = new FileHandler();

    public void addStudent(Scanner scanner) {
        ArrayList<Student> arrayList = fileHandler.readFromFile();

        int id;
        while (true) {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            int finalId = id;
            if (arrayList.stream().anyMatch(s -> s.getId() == finalId)) {
                System.out.println("Duplicate ID! Try again.");
                continue;
            }
            break;
        }

        String name;
        while (true) {
            System.out.print("Enter NAME: ");
            name = scanner.nextLine();

            if (name == null || name.trim().isEmpty()) {
                System.out.println("Name cannot be empty! Try again.");
                continue;
            }
            break;
        }

        double cgpa;
        while (true) {
            System.out.print("Enter CGPA: ");
            cgpa = scanner.nextDouble();

            if (cgpa < 0 || cgpa > 10) {
                System.out.println("Invalid CGPA! Must be 0–10. Try again.");
                continue;
            }
            break;
        }

        Student s = new Student();

        s.setId(id);
        s.setName(name);
        s.setCgpa(cgpa);

        arrayList.add(s);

        fileHandler.writeToFile(arrayList);
        exportToTextFile();

        System.out.println("Student added successfully!");
    }

    public void viewAll() {
        ArrayList<Student> list = fileHandler.readFromFile();

        if (list.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : list) {
            System.out.println(s.toString());
        }
    }

    public void getStudent (int id) {
        ArrayList<Student> arrayList = fileHandler.readFromFile();
        boolean found = false;
        for (Student s : arrayList) {
            if (s.getId() == id) {
                System.out.println(s.toString());
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("\nStudent with ID: " + id + " fetched successfully.\n");
        }
        else {
            System.out.println("\nNo record found with ID: " + id + "\n");
        }
    }

    public void updateStudent (int id, Scanner scanner) {
        ArrayList<Student> arrayList = fileHandler.readFromFile();

        boolean found = false;

        for (Student s : arrayList) {
            if (s.getId() == id) {
                scanner.nextLine();

                String name;
                while (true) {
                    System.out.print("Enter NAME: ");
                    name = scanner.nextLine();

                    if (name == null || name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty! Try again.");
                        continue;
                    }
                    break;
                }

                double cgpa;
                while (true) {
                    System.out.print("Enter CGPA: ");
                    cgpa = scanner.nextDouble();

                    if (cgpa < 0 || cgpa > 10) {
                        System.out.println("Invalid CGPA! Must be 0–10. Try again.");
                        continue;
                    }
                    break;
                }

                s.setName(name);
                s.setCgpa(cgpa);

                fileHandler.writeToFile(arrayList);
                exportToTextFile();

                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Student with ID: " + id + " update successfully.");
        }
        else {
            System.out.println("No record found with ID: " + id);
        }
    }

    public void deleteStudent (int id) {

        ArrayList<Student> arrayList = fileHandler.readFromFile();

        boolean removed = arrayList.removeIf(student -> student.getId() == id);

        if (removed) {
            fileHandler.writeToFile(arrayList);
            exportToTextFile();
            System.out.println("Student with ID: " + id + " deleted successfully.");
        }
        else {
            System.out.println("No record found with ID: " + id);
        }
    }

    public void exportToTextFile() {

        ArrayList<Student> list = fileHandler.readFromFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Super30\\Student Management System - File Handling\\student.txt"))) {

            writer.write("------ STUDENT MANAGEMENT SYSTEM RECORDS ------\n");

            int i=1;
            for (Student s : list) {
                writer.write(i + ": " + s.toString());
                writer.newLine();
                i++;
            }

        } catch (Exception e) {
            System.out.println("Error writing txt file.");
        }
    }

    public void sortByMarks() {
        ArrayList<Student> list = (ArrayList<Student>) fileHandler.readFromFile();

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {

                if (list.get(j).getCgpa() < list.get(j + 1).getCgpa()) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n--- Sorted by Marks (High → Low) ---");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public void sortById() {
        ArrayList<Student> list = (ArrayList<Student>) fileHandler.readFromFile();

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {

                if (list.get(j).getId() > list.get(j + 1).getId()) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        System.out.println("\n--- Sorted by ID (Low → High) ---");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
