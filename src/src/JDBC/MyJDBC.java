package JDBC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;

public class MyJDBC {
    public static Connection connector() {
        java.sql.Connection connection;

        Path path = Path.of("D:\\CoisasDeTexto\\database\\database.txt");

        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String username = Compiler.compileUsername(strings.get(0));
        String password = Compiler.compilePassword(strings.get(1));


        String url = "jdbc:mysql://127.0.0.1:3306/library_schema";
        String user = Compiler.decompileUsername(username);
        String psw = Compiler.decompilePassword(password);

        try {
            connection = DriverManager.getConnection(url, user, psw);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
