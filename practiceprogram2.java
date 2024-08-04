import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Define a class to represent a course
class Course {
    private String id;
    private String name;
    private int credits;

    // Constructor to initialize course data
    public Course(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    // Getters to access course data
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}

// Define a class to represent an enrollment
class Enrollment {
    private String studentId;
    private String courseId;
    private boolean isActive;

    // Constructor to initialize enrollment data
    public Enrollment(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.isActive = true;
    }

    // Getters to access enrollment data
    public String getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public boolean isActive() {
        return isActive;
    }

    // Method to drop a course
    public void dropCourse() {
        this.isActive = false;
    }
}

// Define a class to manage course enrollments
class EnrollmentSystem {
    private Map<String, Course> courses;
    private Map<String, List<Enrollment>> studentEnrollments;
    private Scanner scanner;

    // Constructor to initialize the system
    public EnrollmentSystem() {
        courses = new HashMap<>();
        studentEnrollments = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new course
    public void addCourse() {
        System.out.print("Enter course ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Course course = new Course(id, name, credits);
        courses.put(id, course);
        System.out.println("Course added successfully!");
    }

    // Method to enroll a student in a course
    public void enrollStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        if (courses.containsKey(courseId)) {
            Enrollment enrollment = new Enrollment(studentId, courseId);
            if (studentEnrollments.containsKey(studentId)) {
                studentEnrollments.get(studentId).add(enrollment);
            } else {
                List<Enrollment> enrollments = new ArrayList<>();
                enrollments.add(enrollment);
                studentEnrollments.put(studentId, enrollments);
            }
            System.out.println("Student enrolled successfully!");
        } else {
            System.out.println("Course not found!");
        }
    }

    // Method to drop a course
    public void dropCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        if (studentEnrollments.containsKey(studentId)) {
            for (Enrollment enrollment : studentEnrollments.get(studentId)) {
                if (enrollment.getCourseId().equals(courseId)) {
                    enrollment.dropCourse();
                    System.out.println("Course dropped successfully!");
                    return;
                }
            }
            System.out.println("Student is not enrolled in this course!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Method to view all courses a student is enrolled in
    public void viewEnrollments() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        if (studentEnrollments.containsKey(studentId)) {
            for (Enrollment enrollment : studentEnrollments.get(studentId)) {
                if (enrollment.isActive()) {
                    Course course = courses.get(enrollment.getCourseId());
                    System.out.println("Course ID: " + course.getId());
                    System.out.println("Course Name: " + course.getName());
                    System.out.println("Credits: " + course.getCredits());
                    System.out.println();
                }
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    // Method to start the system and interact with the user
    public void start() {
        while (true) {
            System.out.println("Course Enrollment System");
            System.out.println("1. Add new course");
            System.out.println("2. Enroll student in a course");
            System.out.println("3. Drop a course");
            System.out.println("4
