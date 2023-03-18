import java.util.Scanner;

class Student {
     String regNo;
     String name;
     String email;
     String phone;
     String studentClass;
     String department;

    public Student(String regNo, String name, String email, String phone, String studentClass, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.studentClass = studentClass;
        this.department = department;
    }

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

public class StudentManagementSystem {

    static int MAX_STUDENTS = 100;
    static Student[] students = new Student[MAX_STUDENTS];
    static int numStudents = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("....................Menu..............");
            System.out.println("Enter 1 to add a student");
            System.out.println("Enter 2 to search for a student");
            System.out.println("Enter 3 to display all students");
            System.out.println("Enter 4 to exit");
            System.out.println("Please enter your choice....");
            int choice = scan.nextInt();


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

        Student student = new Student(regNo, name, email, phone, studentClass, department);
        students[numStudents++] = student;

        System.out.println("Student added successfully");
    }

     static void searchStudent(Scanner scanner) {
        System.out.println("Enter student name or reg. no.: ");
        String query = scanner.next();

        for (int i = 0; i < numStudents; i++) {
            Student student = students[i];

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

