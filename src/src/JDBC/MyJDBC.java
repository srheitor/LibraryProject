package JDBC;

import java.sql.*;

public class MyJDBC {
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/library_schema",
                    "root",
                    "989796"

            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
