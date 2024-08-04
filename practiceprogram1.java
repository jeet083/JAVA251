
import java.util.Scanner;
class Student {
    private String id;
    private String name;
    private int age;
    private String department;

    public Student(String id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}

public class StudentRecordSystem {
    private Map<String, Student> studentRecords;
    private Scanner scanner;

    public StudentRecordSystem() {
        studentRecords = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addStudentRecord() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student department: ");
        String department = scanner.nextLine();

        Student student = new Student(id, name, age, department);
        studentRecords.put(id, student);
        System.out.println("Student record added successfully!");
    }


    public void viewStudentRecords() {
        if (studentRecords.isEmpty()) {
            System.out.println("No student records found!");
        } else {
            for (Student student : studentRecords.values()) {
                System.out.println("Student ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Department: " + student.getDepartment());
                System.out.println();
            }
        }
    }
    public void searchStudentRecord() {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();

        if (studentRecords.containsKey(id)) {
            Student student = studentRecords.get(id);
            System.out.println("Student ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Department: " + student.getDepartment());
        } else {
            System.out.println("Student record not found!");
        }
    }

    public void start() {
        while (true) {
            System.out.println("Student Record System");
            System.out.println("1. Add new student record");
            System.out.println("2. View existing student records");
            System.out.println("3. Search for a student record");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudentRecord();
                    break;
                case 2:
                    viewStudentRecords();
                    break;
                case 3:
                    searchStudentRecord();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        system.start();
    }
}
