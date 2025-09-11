package login;

import model.dto.UserDTO;
import repository.UserRepository;

import static core.Utils.SCANNER;

public class LoginScreen {
    public static UserDTO login() {
        System.out.println("Olá, seja bem vindo a livraria de teste do Heitor! \n" +
                "Por favor digite seu usuário e senha: ");

        System.out.print("Usuário: ");
        String userName = SCANNER.nextLine();
        System.out.print("Senha: ");
        int password = SCANNER.nextInt();

        UserDTO user = new UserDTO(userName, password);
        UserRepository.tryLogin(userName, password);
        return user;
    }
}
