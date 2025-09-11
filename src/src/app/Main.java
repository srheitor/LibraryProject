package app;

import login.LoginScreen;
import model.dto.UserDTO;
import repository.BookRepository;
import view.addBook.AddBookScreen;
import view.showBooks.ShowBookScreen;
import view.takeBook.TakeBookScreen;

import java.sql.SQLException;


import static core.Utils.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        boolean isRunning = true;
        UserDTO user = LoginScreen.login();
        BookRepository bookRepository = new BookRepository();

        while (isRunning) {
            if (user.getUserType() == USER_TYPE_ADMIN) {
                System.out.println("Olá admin!, o que gostaria de fazer?");
                int choice = AdminMenu();
                switch (choice) {
                    case 1 -> ShowBookScreen.showScreen(bookRepository);

                    case 2 -> AddBookScreen.addScreen(bookRepository);

                    case 3 -> {
                        System.out.println("Você saiu");
                        isRunning = false;
                    }

                }
            } else if (user.getUserType() == USER_TYPE_USER) {
                System.out.println("Olá usuario!, o que gostaria de fazer?");
                int choice = userMenu();
                switch (choice) {
                    case 1 -> ShowBookScreen.showScreen(bookRepository);

                    case 2 -> TakeBookScreen.takeScreen(bookRepository);

                    case 3 -> System.out.println("Você devolveu um livro");

                    case 4 -> {
                        System.out.println("Você saiu");
                        isRunning = false;
                    }

                }
            } else {
                UserDTO.userNotFound();
            }


        }
    }


    public static int AdminMenu() {
        System.out.println("01. Mostrar lista de livros");
        System.out.println("02. Adicionar um novo livro");
        System.out.println("03. Sair");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }

    public static int userMenu() {
        System.out.println("01. Pegar um livro");
        System.out.println("02. Mostrar lista de livros");
        System.out.println("03. Devolver um livro");
        System.out.println("04. Sair");
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }
}
