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

    public UserDTO(int userType) {
        UserDTO.userType = userType;
    }

    public static void setUserName(String userName) {
        UserDTO.userName = userName;
    }

    public static void setPassword(int password) {
        UserDTO.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public static void welcome(){
        System.out.println("Olá, seja bem vindo a livraria de teste do Heitor! \n" +
                "Por favor digite seu usuário e senha: ");
    }

    public static void userNotFound() {
        System.out.println("Esse usuário não existe");
        System.exit(0);
    }

    public static void helloAdmin() {
        System.out.println("Olá admin!, o que gostaria de fazer?");
    }

    public static void helloUser() {
        System.out.println("Olá usuario!, o que gostaria de fazer?");
    }

    public static void loggOut() {
        System.out.println("Você saiu");
        System.exit(0);
        boolean isRunning = false;
    }

}
