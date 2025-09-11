package repository;

import JDBC.MyJDBC;

import java.sql.*;

public class BookRepository {
    public static void addBook(String bookName, String bookGenre, String bookAuthor){
        String sql = ("INSERT INTO `library_schema`.`books` (`bookName`,`bookGenre`, `bookAuthor`)" + "VALUES (?, ?, ?)");
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            System.out.println("Nome do livro: " + bookName);
            System.out.println("Gênero do livro: " + bookGenre);
            System.out.println("Autor do livro: " + bookAuthor);

            pst = connection.prepareStatement(sql);

            pst.setString(1, bookName);
            pst.setString(2, bookGenre);
            pst.setString(3, bookAuthor);

            pst.executeUpdate();

            System.out.println("Livro adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao adicionar os livros!");
        }

    }

    public static void takeBook(String bookName) {
        String sql = "UPDATE books SET bookState = ? WHERE bookName = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, 0);
            pst.setString(2, bookName);

            pst.executeUpdate();

            System.out.println("Livro emprestado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível pegar o livro");
        }

    }

    public static void returnBook(String bookName) {
        String sql = "UPDATE books SET bookState = ? WHERE bookName = ?";
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
                        resultSet.getString("bookAuthor"));
                if (resultSet.getInt("bookState") == 1) {
                    System.out.print(" | Em estoque");
                    System.out.println("\n");
                } else {
                    System.out.print(" | Emprestado");
                    System.out.println("\n");
                }

            }
        } catch (SQLException e) {
            System.out.println("Não foi carregar a livraria!");
        }
    }

}
