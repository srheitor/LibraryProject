package model.dto;

public class UserDTO {
    private static int idUser;
    private static String userName;
    private static int password;
    private static int userType;

    public UserDTO(String userName, int password) {
        UserDTO.userName = userName;
        UserDTO.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserDTO.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public static void setPassword(int password) {
        UserDTO.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public static int setUserType(int userType) {
        UserDTO.userType = userType;
        return userType;
    }

    public static void userNotFound() {
        System.out.println("Esse usuário não existe");
        System.exit(0);
    }
}
