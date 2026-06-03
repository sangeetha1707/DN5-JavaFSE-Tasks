import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnectionDemo {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "password");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM students");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name"));
            }

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}

/*
1 Ram
2 Ravi
3 Kumar
*/