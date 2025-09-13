package app;

import login.LoginScreen;
import menu.MenuScreen;
import model.dto.UserDTO;
import repository.BookRepository;
import view.addBook.AddBookScreen;
import view.historyAdmin.HistoryAddScreen;
import view.historyAdmin.HistoryAdminScreen;
import view.returnBook.ReturnBookScreen;
import view.showBooks.ShowBookScreen;
import view.takeBook.TakeBookScreen;



import static core.Utils.*;

public class Main {
    public static void main(String[] args){
        boolean isRunning = true;
        UserDTO user = LoginScreen.login();
        BookRepository bookRepository = new BookRepository();

        while (isRunning) {
            if (user.getUserType() == USER_TYPE_ADMIN) {
                UserDTO.helloAdmin();
                int choice = MenuScreen.adminMenu();
                switch (choice) {
                    case 1 -> ShowBookScreen.showScreen(bookRepository);

                    case 2 -> AddBookScreen.addScreen(bookRepository);

                    case 3 -> HistoryAdminScreen.historyAdminScreen(bookRepository);

                    case 4 -> HistoryAddScreen.historyAddScreen(bookRepository);

                    case 5 -> UserDTO.loggOut();

                }
            } else if (user.getUserType() == USER_TYPE_USER) {
                UserDTO.helloUser();
                int choice = MenuScreen.userMenu();
                switch (choice) {
                    case 1 -> ShowBookScreen.showScreen(bookRepository);

                    case 2 -> TakeBookScreen.takeScreen(bookRepository);

                    case 3 -> ReturnBookScreen.returnScreen(bookRepository);

                    case 4 -> System.out.println("Seu histórico de livros");

                    case 5 -> UserDTO.loggOut();
                }
            } else {
                UserDTO.userNotFound();
            }


        }
    }


}
