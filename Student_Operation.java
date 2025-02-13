package project3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class Student_Operation {

    // method to add a student
    public static void addStudent(String name, String className, int roll_no){
        Connection cc = Connection2.getConnection();
        String sql = "INSERT INTO student1 (name, class, roll_no) values (?, ?, ?)";

        try {
            PreparedStatement pp = cc.prepareStatement(sql);
            pp.setString(1, name);
            pp.setString(2, className);
            pp.setInt(3, roll_no);

            int rowsInserted = pp.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("✅ Student Added Successfully!");
            }
            cc.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // method to view all students
    public static void viewStudents() {
        Connection cc = Connection2.getConnection();
        String sql = "SELECT * FROM student1";

        try {
            PreparedStatement pp = cc.prepareStatement(sql);
            ResultSet rs = pp.executeQuery();

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id") +
                        ", Name: " + rs.getString("name") +
                        ", Class: " + rs.getString("class") +
                        ", Roll No: " + rs.getInt("roll_no"));
            }
            cc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to update students
    public static void updateStudent(int studentId, String newName) {
        Connection cc = Connection2.getConnection();
        String sql = "UPDATE student1 SET name = ? WHERE student_id = ?";

        try {
            PreparedStatement pp = cc.prepareStatement(sql);
            pp.setString(1, newName);
            pp.setInt(2, studentId);

            int rowsUpdated = pp.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Student Updated Successfully!");
            }
            cc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // method to delete students
    public static void deleteStudent(int studentId) {
        Connection cc = Connection2.getConnection();
        String sql = "DELETE FROM student1 WHERE student_id = ?";

        try {
            PreparedStatement pp = cc.prepareStatement(sql);
            pp.setInt(1, studentId);

            int rowsDeleted = pp.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Student Deleted Successfully!");
            }
            cc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
