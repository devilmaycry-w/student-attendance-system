package project3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Attendance System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Name");
            System.out.println("4. Delete Student");
            System.out.println("5. Mark Attendance");
            System.out.println("6. View Attendance");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter Class: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter Roll No: ");
                    int rollNo = scanner.nextInt();
                    Student_Operation.addStudent(name, className, rollNo);
                    break;

                case 2:
                    Student_Operation.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    scanner.nextLine(); // Consume newline
                    String newName = scanner.nextLine();
                    Student_Operation.updateStudent(studentId, newName);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    Student_Operation.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Student ID to Mark Attendance: ");
                    int attStudentId = scanner.nextInt();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    scanner.nextLine(); // Consume newline
                    String date = scanner.nextLine();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = scanner.nextLine();
                    Attendance_operation.markAttendance(attStudentId, date, status);
                    break;

                case 6:
                    System.out.print("Enter Student ID to View Attendance: ");
                    int viewStudentId = scanner.nextInt();
                    Attendance_operation.viewAttendance(viewStudentId);
                    break;

                case 0:
                    System.out.println("Exiting... 🚪");
                    break;

                default:
                    System.out.println("❌ Invalid Choice! Try Again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
