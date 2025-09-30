package repository;

import JDBC.MyJDBC;
import core.Utils;
import model.dto.UserDTO;
import view.addBook.AddBookScreen;
import view.historyAdmin.HistoryAddScreen;
import view.historyAdmin.HistoryAdminScreen;
import view.historyUser.HistoryUserScreen;
import view.removeBook.RemoveScreen;
import view.returnBook.ReturnBookScreen;
import view.showBooks.ShowBookScreen;
import view.takeBook.TakeBookScreen;

import java.sql.*;

public class BookRepository {
    public static void addBook(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookCondition, String bookISBN) {

        AddBookScreen addScreen = new AddBookScreen();
        String sql = ("CALL addBooks(?, ?, ?, ?, ?, ?)");

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            addScreen.printAddBookInfo(bookName, bookGenre, bookAuthor, bookPublisher, bookCondition, bookISBN);

            pst = connection.prepareStatement(sql);

            pst.setString(1, bookName);
            pst.setString(2, bookGenre);
            pst.setString(3, bookAuthor);
            pst.setString(4, bookPublisher);
            pst.setString(5, bookCondition);
            pst.setString(6, bookISBN);

            pst.executeUpdate();

            addScreen.addBookSuccessful();
        } catch (SQLException e) {
            addScreen.addBookError();
        }
        Utils.waitEnter();
    }

    public void deleteBook(int bookID) {
        RemoveScreen remove = new RemoveScreen();
        String sql = ("DELETE FROM books WHERE bookID = ?");

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, bookID);

            pst.executeUpdate();

            ResultSet result = pst.executeQuery();

            String bookName = result.getString("bookName");
            String bookGenre = result.getString("bookGenre");
            String bookAuthor = result.getString("bookAuthor");
            String bookPublisher = result.getString("bookPublisher");
            String bookCondition = result.getString("bookCondition");
            String bookISBN = result.getString("bookISBN");


            remove.printRemoveBookInfo(bookName, bookGenre, bookAuthor, bookPublisher, bookCondition, bookISBN);

            remove.removeBookSuccessful();
        } catch (SQLException e) {
            remove.removeBookError();
        }
        Utils.waitEnter();
    }

    public static void takeBook(String bookName) {

        TakeBookScreen takeScreen = new TakeBookScreen();

        String sql = "UPDATE books SET bookStatus = ? WHERE bookName = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setString(1, "EMPRESTADO");
            pst.setString(2, bookName);

            pst.executeUpdate();


            takeScreen.takeBookSuccessful();

        } catch (SQLException e) {
            System.out.println(bookName);
            takeScreen.takeBookError();
        }
        Utils.waitEnter();
    }

    public static void returnBook(String bookName) {

        ReturnBookScreen returnBook = new ReturnBookScreen();

        String sql = "UPDATE books SET bookStatus = ? WHERE bookName = ?";
        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setString(1, "EM ESTOQUE");
            pst.setString(2, bookName);

            pst.executeUpdate();

            returnBook.returnBookSuccessful();

        } catch (SQLException e) {
            returnBook.returnBookError();
        }

    }

    public static void showBooks() {
        String sql = "SELECT * FROM BOOKS";

        ShowBookScreen showScreen = new ShowBookScreen();

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
                if (resultSet.getString("bookStatus").equals("EM ESTOQUE")) {
                    showScreen.inShelves();
                } else {
                    showScreen.notInShelves();
                }
            }

        } catch (SQLException e) {
            showScreen.libraryError();
        }
        Utils.waitEnter();
        Utils.cleanScreen();
    }

    public static void showAddHistory() {
        String sql = "SELECT * FROM addBookHistory ORDER BY date DESC";

        HistoryAddScreen showScreen = new HistoryAddScreen();


        try {
            Statement statement = MyJDBC.connector().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.print("ID 0" + resultSet.getInt("bookID") + " | " +
                        resultSet.getString("bookName") + " | " +
                        resultSet.getString("bookCondition") + " | " +
                        resultSet.getString("date") + " | " +
                        resultSet.getString("ISBN") + " | ");
                System.out.println("\n");
            }

        } catch (SQLException e) {
            showScreen.historyAddError();
        }
        Utils.waitEnter();
    }

    public static void showAdminHistory() {
        String sql = "SELECT * FROM showHistory";

        HistoryAdminScreen showScreen = new HistoryAdminScreen();

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

        } catch (SQLException e) {
            showScreen.historyAdminError();
        }
        Utils.waitEnter();
    }

    public static void showUserHistory() {
        HistoryUserScreen showScreen = new HistoryUserScreen();
        String sql = "SELECT * FROM showHistory WHERE idUser = ?";
        int idUser = UserDTO.getIdUser();

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setInt(1, idUser);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                System.out.print("ID 0" + result.getInt("idHistory") + " | " +
                        result.getString("bookName") + " | " +
                        result.getString("ISBN") + " | " +
                        result.getString("date") + " | ");

            }

        } catch (SQLException e) {
            showScreen.historyUserError();

        }
        Utils.waitEnter();
    }
}
