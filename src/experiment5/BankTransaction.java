package experiment5;
import java.sql.*;

public class BankTransaction {

    static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    static final String USER = "root";
    static final String PASSWORD = "6789";

    public static void main(String[] args) {

        Connection con = null;

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Disable AutoCommit (Start Transaction)
            con.setAutoCommit(false);

            int fromAcc = 101;
            int toAcc = 102;
            double amount = 2000;

            // Check balance
            PreparedStatement ps1 = con.prepareStatement(
                "SELECT balance FROM accounts WHERE acc_no=?"
            );
            ps1.setInt(1, fromAcc);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    // Debit
                    PreparedStatement debit = con.prepareStatement(
                        "UPDATE accounts SET balance = balance - ? WHERE acc_no=?"
                    );
                    debit.setDouble(1, amount);
                    debit.setInt(2, fromAcc);
                    debit.executeUpdate();

                    // Credit
                    PreparedStatement credit = con.prepareStatement(
                        "UPDATE accounts SET balance = balance + ? WHERE acc_no=?"
                    );
                    credit.setDouble(1, amount);
                    credit.setInt(2, toAcc);
                    credit.executeUpdate();

                    // Commit Transaction
                    con.commit();
                    System.out.println("Transaction Successful!");

                } else {
                    System.out.println("Insufficient Balance!");
                    con.rollback();
                }
            }

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // Rollback on error
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}