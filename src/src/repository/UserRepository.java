package repository;

import JDBC.MyJDBC;
import model.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static core.Utils.*;

public class UserRepository {
    public static boolean tryLoginAdmin(String userName, int password) {
        String sql = "SELECT * FROM users WHERE userName = ? and password = ? and userAdmin = 1";
        boolean success = false;

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setString(1, userName);
            pst.setInt(2, password);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                UserDTO.setUserName(userName);
                UserDTO.setPassword(password);
                success = true;
            }

        } catch (SQLException e) {
            System.out.println("Usuário não encontrado!");
        }

        return success;
    }

    public static boolean tryLoginUser(String userName, int password) {
        String sql = "SELECT * FROM users WHERE userName = ? and password = ? and userAdmin = 0";
        boolean success = false;

        try {
            Connection connection = MyJDBC.connector();
            PreparedStatement pst;

            pst = connection.prepareStatement(sql);

            pst.setString(1, userName /*admin1*/);
            pst.setInt(2, password /*12345*/);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                UserDTO.setUserName(userName);
                UserDTO.setPassword(password);
                success = true;
            }


        } catch (SQLException e) {
            System.out.println("Usuário não encontrado!");
        }

        return success;
    }

    public static void tryLogin(String userName, int password) {
        int userType = 0;

        if (tryLoginAdmin(userName, password)) {
            userType = new UserDTO(USER_TYPE_ADMIN).getUserType();
        } else if (tryLoginUser(userName, password)) {
            userType = new UserDTO(USER_TYPE_USER).getUserType();
        } else {
            UserDTO.userNotFound();
        }
    }
}
