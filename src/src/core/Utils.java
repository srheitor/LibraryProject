package core;

import JDBC.MyJDBC;
import core.dto.UserDTO;

import java.sql.*;
import java.util.Scanner;

public class Utils {
    public static Scanner SCANNER = new Scanner(System.in);
    public static int USER_TYPE_ADMIN = 0;
    public static int USER_TYPE_USER = 1;

    public static void showBooks(){
        String sql = "SELECT * FROM BOOKS";

        try {
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
        } catch (SQLException e) {
            System.out.println("Não foi carregar a livraria :(");
        }
    }

    public static void takeBook(int bookId){
        String sql = "UPDATE books SET bookstate = ? WHERE IDBOOKS = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, 0);
            pst.setInt(2, bookId);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não foi possível pegar o livro");
        }

    }

    public static void login(int bookId) {
        String sql = "SELECT * FROM users WHERE userName = ? and password = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, UserDTO.getUserName());
            pst.setInt(2, bookId);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Não foi possível pegar o livro");
        }
    }
}
