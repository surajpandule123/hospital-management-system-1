package hospital.management.system;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class conn {

    Connection connection;
    Statement statement;

    public conn() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_management_system",
                    "root",
                    "Suraj@1721");

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}