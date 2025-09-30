package model.dto;

public class UserDTO {
    private static int idUser;
    private static String userName;
    private static String password;
    private static String userType;

    public UserDTO(String userName, String password) {
        UserDTO.userName = userName;
        UserDTO.password = password;
    }

    public UserDTO(String userType) {
        UserDTO.userType = userType;
    }

    public static void setUserName(String userName) {
        UserDTO.userName = userName;
    }

    public static void setPassword(String password) {
        UserDTO.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        UserDTO.idUser = idUser;
    }


    public static void welcome() {
        System.out.println("Olá, seja bem vindo a livraria de teste do Heitor! \n" +
                "Por favor digite seu usuário e senha: ");
    }

    public static void userNotFound() {
        System.out.println("Nome de usuário ou senha incorretos!");
    }

    public static void helloAdmin() {
        System.out.println("Olá admin!, o que gostaria de fazer?");
    }

    public static void helloUser() {
        System.out.println("Olá usuario!, o que gostaria de fazer?");
    }

    public static void loggOut() {
        System.out.println("Você saiu");
    }

    public static void invalidOption() {
        System.out.println("OPÇÃO INVÁLIDA");
    }
}
