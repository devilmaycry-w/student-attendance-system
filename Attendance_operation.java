package project3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Attendance_operation {

    // ✅ Method to Mark Attendance
    public static void markAttendance(int studentId, String date, String status) {
        Connection conn = Connection2.getConnection();
        String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            pstmt.setString(2, date);
            pstmt.setString(3, status);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Attendance Marked Successfully!");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Method to View Attendance for a Student
    public static void viewAttendance(int studentId) {
        Connection conn = Connection2.getConnection();
        String sql = "SELECT * FROM attendance WHERE student_id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n--- Attendance Record ---");
            while (rs.next()) {
                System.out.println("Date: " + rs.getString("date") +
                        ", Status: " + rs.getString("status"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
