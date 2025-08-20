import java.sql.*;

public class MyJDBC {
    public static void conect() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/library_schema",
                    "root",
                    "989796"

            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKS");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("idbooks"));
                System.out.println(resultSet.getString("booksname"));
                if(resultSet.getInt("bookstate") == 1){
                    System.out.println("Em estoque");
                }else{
                    System.out.println("Emprestado");
                }
                System.out.println(resultSet.getString("booksgenre"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
