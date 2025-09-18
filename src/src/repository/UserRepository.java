package repository;

import JDBC.MyJDBC;
import model.dto.UserDTO;
import view.historyUser.HistoryUserScreen;

import java.sql.*;

import static core.Utils.*;

public class UserRepository {
    public static boolean tryLoginAdmin(String userName, String password) {
        String sql = "SELECT * FROM users WHERE userName = ? and password = ? and userType = 'ADMIN'";
        boolean success = false;

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setString(1, userName);
            pst.setString(2, password);

            ResultSet result = pst.executeQuery();

            int idUser = 0;
            while (result.next()) {
                UserDTO.setUserName(userName);
                UserDTO.setPassword(password);
                idUser = result.getInt("idUser");
                UserDTO.setIdUser(idUser);
                success = true;
            }


        } catch (SQLException e) {
            System.out.println("Usuário não encontrado!");
        }

        return success;
    }

    public static boolean tryLoginUser(String userName, String password) {
        String sql = "SELECT * FROM users WHERE userName = ? and password = ? and userType = 'USER'";
        boolean success = false;

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setString(1, userName);
            pst.setString(2, password);

            ResultSet result = pst.executeQuery();

            int idUser = 0;
            while (result.next()) {
                UserDTO.setUserName(userName);
                UserDTO.setPassword(password);

                idUser = result.getInt("idUser");
                UserDTO.setIdUser(idUser);
                success = true;
            }


        } catch (SQLException e) {
            System.out.println("Usuário não encontrado!");
        }

        return success;
    }

    public static void tryLogin(String userName, String password) {
        String userType;

        if (tryLoginAdmin(userName, password)) {
            userType = new UserDTO(USER_TYPE_ADMIN).getUserType();
        } else if (tryLoginUser(userName, password)) {
            userType = new UserDTO(USER_TYPE_USER).getUserType();
        } else {
            System.out.println("");
        }
    }

    public static void getUserData() {
        String sql = "SELECT * FROM users";

        HistoryUserScreen showScreen = new HistoryUserScreen();

        try {
            Statement statement = MyJDBC.connector().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UserDTO.setIdUser(resultSet.getInt("idUser"));
            }


        } catch (SQLException e) {
            showScreen.historyUserError();
        }
    }
}
