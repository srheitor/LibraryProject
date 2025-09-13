package view.takeBook;


import repository.BookRepository;
import view.showBooks.ShowBookScreen;

import static core.Utils.SCANNER;

public class TakeBookScreen {
    public static void takeScreen(BookRepository repository) {
        ShowBookScreen.showScreen(repository);

        System.out.println("Digite o nome do livro que gostaria de pegar emprestado: ");
        String bookName = SCANNER.nextLine().toUpperCase();

        repository.takeBook(bookName);

    }
}
