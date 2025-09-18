package app;

import core.Utils;
import login.LoginScreen;
import menu.MenuScreen;
import model.dto.UserDTO;
import repository.BookRepository;
import view.addBook.AddBookScreen;
import view.historyAdmin.HistoryAddScreen;
import view.historyAdmin.HistoryAdminScreen;
import view.historyUser.HistoryUserScreen;
import view.removeBook.RemoveScreen;
import view.returnBook.ReturnBookScreen;
import view.showBooks.ShowBookScreen;
import view.takeBook.TakeBookScreen;


import static core.Utils.*;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        UserDTO user = LoginScreen.login();
        BookRepository bookRepository = new BookRepository();

        while (isRunning) {
            if (user.getUserType() == USER_TYPE_ADMIN) {
                UserDTO.helloAdmin();
                try {
                    int choice = MenuScreen.adminMenu();
                    switch (choice) {
                        case 1 -> {
                            ShowBookScreen.showScreen(bookRepository);
                            Utils.waitEnter();
                            Utils.cleanScreen();
                        }

                        case 2 -> AddBookScreen.addScreen(bookRepository);

                        case 3 -> HistoryAdminScreen.historyAdminScreen(bookRepository);

                        case 4 -> HistoryAddScreen.historyAddScreen(bookRepository);

                        case 5 -> RemoveScreen.removeScreen(bookRepository);

                        case 6 -> {
                            UserDTO.loggOut();
                            isRunning = false;
                        }
                        default -> UserDTO.invalidOption();
                    }

                } catch (NumberFormatException e) {
                    Utils.cleanScreen();
                    Utils.invalidInput();
                }


            } else if (user.getUserType() == USER_TYPE_USER) {
                UserDTO.helloUser();
                int choice = MenuScreen.userMenu();
                switch (choice) {
                    case 1 -> ShowBookScreen.showScreen(bookRepository);

                    case 2 -> TakeBookScreen.takeScreen(bookRepository);

                    case 3 -> ReturnBookScreen.returnScreen(bookRepository);

                    case 4 -> HistoryUserScreen.historyUserScreen(bookRepository);

                    case 5 -> {
                        UserDTO.loggOut();
                        isRunning = false;
                    }
                }
            } else {
                UserDTO.userNotFound();
                isRunning = false;
            }


        }
    }


}
