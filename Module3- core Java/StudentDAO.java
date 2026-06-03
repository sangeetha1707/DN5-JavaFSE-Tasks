import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "password");

            PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO students VALUES(?, ?)");

            insert.setInt(1, 101);
            insert.setString(2, "Arun");

            insert.executeUpdate();

            PreparedStatement update = con.prepareStatement(
                    "UPDATE students SET name=? WHERE id=?");

            update.setString(1, "Arunkumar");
            update.setInt(2, 101);

            update.executeUpdate();

            System.out.println("Insert and Update Successful");

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}

/*
Insert and Update Successful
*/