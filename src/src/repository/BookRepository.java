package repository;

import JDBC.MyJDBC;
import core.Utils;

import java.sql.*;

public class BookRepository {
    public static void addBook(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookCondition, String bookISBN) {
        String sql = ("CALL addBooks(?, ?, ?, ?, ?, ?)");
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            System.out.println("Nome do livro: " + bookName);
            System.out.println("Gênero do livro: " + bookGenre);
            System.out.println("Autor do livro: " + bookAuthor);
            System.out.println("Nome do livro: " + bookPublisher);
            System.out.println("Gênero do livro: " + bookCondition);
            System.out.println("Autor do livro: " + bookISBN);

            pst = connection.prepareStatement(sql);

            pst.setString(1, bookName);
            pst.setString(2, bookGenre);
            pst.setString(3, bookAuthor);
            pst.setString(4, bookPublisher);
            pst.setString(5, bookCondition);
            pst.setString(6, bookISBN);

            pst.executeUpdate();

            System.out.println("Livro adicionado com sucesso!");

            Utils.waitEnter();
            Utils.cleanScreen();

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao adicionar os livros!");
        }

    }

    public static void takeBook(String bookName) {
        String sql = "UPDATE books SET bookStatus = ? WHERE bookName = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, 0);
            pst.setString(2, bookName);

            pst.executeUpdate();

            System.out.println("Livro emprestado com sucesso!");

            Utils.waitEnter();
            Utils.cleanScreen();

        } catch (SQLException e) {
            System.out.println("Não foi possível pegar o livro");
        }

    }

    public static void returnBook(String bookName) {
        String sql = "UPDATE books SET bookStatus = ? WHERE bookName = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, 1);
            pst.setString(2, bookName);

            pst.executeUpdate();

            System.out.println("Livro devolvido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível pegar o livro");
        }

    }

    public static void showBooks() {
        String sql = "SELECT * FROM BOOKS";


        try {
            Statement statement = MyJDBC.connector().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print("ID 0" + resultSet.getInt("bookId") + " | " +
                        resultSet.getString("bookName") + " | " +
                        resultSet.getString("bookGenre") + " | " +
                        resultSet.getString("bookAuthor") + " | " +
                        resultSet.getString("bookPublisher") + " | " +
                        resultSet.getString("bookCondition") + " | " +
                        resultSet.getString("ISBN") + " | ");
                if (resultSet.getInt("bookStatus") == 1) {
                    System.out.print(" | Em estoque");
                    System.out.println("\n");
                } else {
                    System.out.print(" | Emprestado");
                    System.out.println("\n");
                }
            }

            Utils.waitEnter();
            Utils.cleanScreen();

        } catch (SQLException e) {
            System.out.println("Não foi possível carregar a livraria!");
        }
    }

    public static void showAddHistory() {
        String sql = "SELECT * FROM addBookHistory ORDER BY dateTimeAdd DESC";


        try {
            Statement statement = MyJDBC.connector().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print("ID 0" + resultSet.getInt("bookID") + " | " +
                        resultSet.getString("bookName") + " | " +
                        resultSet.getString("bookCondition") + " | " +
                        resultSet.getString("dateTimeAdd") + " | " +
                        resultSet.getString("ISBN") + " | ");
                System.out.println("\n");
            }

            Utils.waitEnter();
            Utils.cleanScreen();

        } catch (SQLException e) {
            System.out.println("Não foi possível carregar a livraria!");
        }
    }

    public static void showAdminHistory() {
        String sql = "SELECT * FROM showHistory";


        try {
            Statement statement = MyJDBC.connector().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print("ID 0" + resultSet.getInt("idHistory") + " | " +
                        resultSet.getString("bookName") + " | " +
                        resultSet.getString("userName") + " | " +
                        resultSet.getString("ISBN") + " | " +
                        resultSet.getString("dateTimeTaken"));
                System.out.println("\n");
            }

            Utils.waitEnter();
            Utils.cleanScreen();

        } catch (SQLException e) {
            System.out.println("Não foi possível carregar o histórico!");
        }
    }

}
