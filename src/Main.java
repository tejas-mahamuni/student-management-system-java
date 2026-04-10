import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Services service = new Services();

        while (true) {

            System.out.println("\n------ STUDENT MANAGEMENT SYSTEM ------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort by CGPA");
            System.out.println("7. Sort by ID");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.addStudent(sc);
                    break;
                case 2:
                    service.viewAll();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    service.getStudent(searchId);
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    int updateId = sc.nextInt();
                    service.updateStudent(updateId, sc);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int deleteId = sc.nextInt();
                    service.deleteStudent(deleteId);
                    break;

                case 6:
                    service.sortByMarks();  // CGPA sort
                    break;

                case 7:
                    service.sortById();
                    break;

                case 8:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}