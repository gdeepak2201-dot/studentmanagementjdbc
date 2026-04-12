package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class studentapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Add New Student ---");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        try {
            // Calling the connection from your DBConnection class
            Connection con = DBConnection.getConnection();

            if (con != null) {
                String query = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, course);

                int rows = pst.executeUpdate();
                if (rows > 0) {
                    System.out.println("Student registered successfully!");
                }
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}