package view.historyAdmin;

import repository.BookRepository;

public class HistoryAddScreen {
    public static void historyAddScreen(BookRepository repository) {
        System.out.println("Aqui está o histórico de livros que foram adicionados recentemente: ");
        repository.showAddHistory();
    }
}
