package view.historyUser;

import repository.BookRepository;

public class HistoryUserScreen {
    public static void historyUserScreen(BookRepository repository) {
        System.out.println("Aqui está o histórico de livros que você pegou: ");
        repository.showUserHistory();
    }

    public static void historyUserError(){
        System.out.println("Ocorreu um erro ao carregar seu histórico! ");
    }
}
