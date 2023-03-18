import java.util.Scanner;

// Define the Student class
class Student {
     String regNo;
     String name;
     String email;
     String phone;
     String studentClass;
     String department;


     // Define the constructor for the student class
    public Student(String regNo, String name, String email, String phone, String studentClass, String department) {
       //Initialize the fields with the provided value
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.studentClass = studentClass;
        this.department = department;
    }

    // Define a method to print the details of a student

    public void printDetails() {
        System.out.println("Reg. No.: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + studentClass);
        System.out.println("Department: " + department);
    }

    public String getName() {
        return name;
    }

    public String getRegNo() {
        return regNo;
    }
}

// Define the main class
public class StudentManagementSystem {

  // Create an array to hold up to 100 students
    static int MAX_STUDENTS = 100;
    static Student[] students = new Student[MAX_STUDENTS];
    // Initialize a counter to keep track of how many students have been added to the array
    static int numStudents = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
     //  Start a loop that will continue until the user chooses to exit
        while (true) {
            // Display the menu options to the user
            System.out.println("....................Menu..............");
            System.out.println("Enter 1 to add a student");
            System.out.println("Enter 2 to search for a student");
            System.out.println("Enter 3 to display all students");
            System.out.println("Enter 4 to exit");
            System.out.println("Please enter your choice....");
            // Read the user's choice from the input
            int choice = scan.nextInt();

         // use a switch statement to handle the user's choice
            switch (choice) {
                case 1:
                    addStudent(scan);
                    break;
                case 2:
                    searchStudent(scan);
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

     static void addStudent(Scanner scanner) {
        // Ask the user to enter the details of the new student
        System.out.println("Enter student details:");
        System.out.print("Reg. No.: ");
        String regNo = scanner.next();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();
        System.out.print("Class: ");
        String studentClass = scanner.next();
        System.out.print("Department: ");
        String department = scanner.next();
         
        // Create a new Student object with the entered details
        Student student = new Student(regNo, name, email, phone, studentClass, department);
        // Increment the counter to indicate that a new student has been added
        students[numStudents++] = student;
        // Notify the user that the student has been added successfully
        System.out.println("Student added successfully");
    }

     static void searchStudent(Scanner scanner) {
        // Ask the user to enter the Reg. No. or Name of the student to search for
        System.out.println("Enter student name or reg. no.: ");
        String query = scanner.next();
        // Loop through the array of students to find the matching student
        for (int i = 0; i < numStudents; i++) {
            Student student = students[i];
        // If a matching student is found, print
            if (student.getName().equalsIgnoreCase(query) || student.getRegNo().equalsIgnoreCase(query)) {
                student.printDetails();
                return;
            }
        }

        System.out.println("Student not found");
    }

     static void displayAllStudents() {
        if (numStudents == 0) {
            System.out.println("No students added yet");
            return;
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + " details:");
            students[i].printDetails();
            System.out.println();
        }
    }
}

