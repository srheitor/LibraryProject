package JDBC;

import java.sql.*;

public class MyJDBC {
    public static Connection connector() {
        java.sql.Connection connection;
        String url = "jdbc:mysql://127.0.0.1:3306/library_schema";
        String user = "root";
        String password = "989796";

        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
