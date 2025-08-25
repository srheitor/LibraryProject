package core;

import JDBC.MyJDBC;

import java.sql.*;
import java.util.Scanner;

public class Utils {
    public static Scanner SCANNER = new Scanner(System.in);

    public static void showBooks() throws SQLException {
        String sql = "SELECT * FROM BOOKS";

        Statement statement = MyJDBC.connector().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("idbooks"));
            System.out.println(resultSet.getString("bookname"));
            if (resultSet.getInt("bookstate") == 1) {
                System.out.println("Em estoque");
            } else {
                System.out.println("Emprestado");
            }
            System.out.println(resultSet.getString("booksgenre"));

        }
    }
    public static void takeBook(int bookId) throws SQLException {
        String sql = "UPDATE books SET bookstate = ? WHERE IDBOOKS = ?";
        Connection connection = MyJDBC.connector();
        PreparedStatement pst;

        pst = connection.prepareStatement(sql);

        pst.setInt(1, 0);
        pst.setInt(2, bookId);

        pst.executeUpdate();

    }
}