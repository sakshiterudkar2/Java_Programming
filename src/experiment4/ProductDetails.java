package experiment4;

import java.sql.*;

public class ProductDetails {
    public static void main(String[] args) {

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String password = "6789"; // change if needed

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            String query = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Display Data
            System.out.println("Product Details:");
            System.out.println("---------------------------");

            while (rs.next()) {
                int id = rs.getInt("Product_ID");
                String name = rs.getString("Product_Name");
                int price = rs.getInt("Price");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println("---------------------------");
            }

            // 6. Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}