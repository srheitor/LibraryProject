package view.showBooks;

import model.dto.BookDTO;
import repository.BookRepository;

import static core.Utils.SCANNER;

public class ShowBookScreen {
    public static void showScreen(BookRepository repository) {
        System.out.println("Aqui está o estoque dos livros: ");
        repository.showBooks();
    }
}
