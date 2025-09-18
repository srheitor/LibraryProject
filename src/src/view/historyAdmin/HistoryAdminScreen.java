package view.historyAdmin;

import repository.BookRepository;

public class HistoryAdminScreen {
    public static void historyAdminScreen(BookRepository repository) {
        System.out.println("Aqui está o histórico de livros que foram pegos: ");
        repository.showAdminHistory();
    }

    public static void historyAdminError(){
        System.out.println("Não foi possível carregar a livraria!");
    }
}
