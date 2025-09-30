package view.login;

import model.dto.UserDTO;
import repository.UserRepository;

import static core.Utils.SCANNER;

public class LoginScreen {
    public static UserDTO login() {
        UserDTO.welcome();

        System.out.print("Usuário: ");
        String userName = SCANNER.nextLine();
        System.out.print("Senha: ");
        String password = SCANNER.nextLine();

        UserDTO user = new UserDTO(userName, password);
        UserRepository.tryLogin(userName, password);

        return user;
    }
}
