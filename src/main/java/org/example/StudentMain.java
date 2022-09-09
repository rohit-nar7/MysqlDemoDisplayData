package org.example;

import java.sql.*;

public class StudentMain {
    public static void main(String[] args) {
        StudentMain studentMain = new StudentMain();
        studentMain.getAllStudentDetails();
    }

    public void getAllStudentDetails() {
        try {
            String url = "jdbc:mysql://localhost:3306/school";
            String user = "root";
            String pass = "admin";

            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                System.out.println("connection succeeded");
                Statement statement = connection.createStatement();

                ResultSet show = statement.executeQuery("SELECT * FROM school.studentdetails;");

                while (show.next()) {

                    System.out.print("Student_Name: " + show.getString("name"));
                    System.out.print(", roll_No: " + show.getInt("rollNo"));
                    System.out.print(", grades: " + show.getString(3));
                    System.out.println(", age: " + show.getInt("age"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
