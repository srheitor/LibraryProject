package core;

import JDBC.MyJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utils {
    public static Scanner SCANNER = new Scanner(System.in);

    public static void showBooks() throws SQLException {

        Statement statement = MyJDBC.connect().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKS");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("idbooks"));
            System.out.println(resultSet.getString("booksname"));
            if (resultSet.getInt("bookstate") == 1) {
                System.out.println("Em estoque");
            } else {
                System.out.println("Emprestado");
            }
            System.out.println(resultSet.getString("booksgenre"));

        }
    }
    public static void takeBook(int bookId) throws SQLException {

        Statement statement = MyJDBC.connect().createStatement();
        ResultSet resultSet = statement.executeQuery("UPDATE BOOKS SET BOOKSTATE = 0 WHERE IDBOOKS = bookId");;

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("idbooks"));
            System.out.println(resultSet.getString("booksname"));
            if (resultSet.getInt("bookstate") == 1) {
                System.out.println("Em estoque");
            } else {
                System.out.println("Emprestado");
            }
            System.out.println(resultSet.getString("booksgenre"));

        }
    }


}