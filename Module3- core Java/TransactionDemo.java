import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankdb",
                    "root",
                    "password");

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance-? WHERE id=?");

            debit.setInt(1, 1000);
            debit.setInt(2, 1);

            debit.executeUpdate();

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance=balance+? WHERE id=?");

            credit.setInt(1, 1000);
            credit.setInt(2, 2);

            credit.executeUpdate();

            con.commit();

            System.out.println("Transfer Successful");

            con.close();

        } catch(Exception e) {

            System.out.println("Transaction Failed");
        }
    }
}

/*
Transfer Successful
*/